package com.oatmusic.oat_music_server.web.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(
    exclude = [
        DataSourceAutoConfiguration::class,
        DataSourceTransactionManagerAutoConfiguration::class,
        HibernateJpaAutoConfiguration::class
    ])
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager",
    basePackages = ["com.oatmusic.oat_music_server.web.repository"]
)
class DatasourceConfig {

    private val logger: Logger = LoggerFactory.getLogger(DatasourceConfig::class.java)

    @Value("\${${oat_music}.jpa.database-platform}")
    val orgHibernateDialect = ""

    @Value("\${${oat_music}.datasource.driverClassName}")
    val driverClassName = ""

    @Value(value = "\${${oat_music}.datasource.url:jdbc:postgresql://localhost:5432/oat_music}")
    val databaseUrl = ""

    @Value("\${${oat_music}.datasource.username:oat_music}")
    val username = ""

    @Value("\${${oat_music}.datasource.password:12345}")
    val passwd = ""

    @Value("\${${oat_music}.jpa.show-sql:true}")
    val showSql = ""

    @Value("\${${oat_music}.jpa.format-sql:true}")
    val formatSql: String = ""

    @Value("\${${oat_music}.jpa.hibernate.ddl-auto:create-drop}")
    val hibernateDDL = ""

    @Value("\${${oat_music}.entity.package.to.scan}")
    val entityPackageToScan = ""

    @Value("\${${oat_music}.database.type}")
    val databaseType = Database.POSTGRESQL

    @PostConstruct
    fun afterConstruct(){
        logger.info("========= Data source config bean finish construct ============")
    }

    @Bean
    @Profile(*[ "test" ])
    fun standaloneDatasource(): DataSource {
        return EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:/schema_test.sql")
            .addScript("classpath:/data_test.sql")
            .build()
    }

    @Bean
    @Profile(*[ "dev" ])
    fun postgresDatasource(): DataSource {
        val dataSource = DataSourceBuilder.create()
        dataSource.driverClassName(driverClassName)
        dataSource.url(databaseUrl)
        dataSource.username(username)
        dataSource.password(passwd)
        return dataSource.build()
    }

    @Bean("entityManagerFactory")
    fun entityManagerFactory(
        @Autowired datasource: DataSource,
        @Qualifier("hibernateAdapter") jpaVendorAdapter: JpaVendorAdapter
    ): EntityManagerFactory? {

        val properties = Properties()
        properties["hibernate.dialect"] = orgHibernateDialect
        properties["hibernate.show_sql"] = showSql
        properties["hibernate.format_sql"] = formatSql
        properties["hibernate.hbm2ddl.auto"] = hibernateDDL
        properties["spring.jpa.defer-datasource-initialization"] = true

        val em = LocalContainerEntityManagerFactoryBean()

        em.jpaVendorAdapter = jpaVendorAdapter
        em.setJpaProperties(properties)
        em.setPackagesToScan(entityPackageToScan)
        em.dataSource = datasource
        em.persistenceUnitName = "oat_music"
        em.afterPropertiesSet()
        return em.`object`
    }

    @Bean("entityManager")
    fun entityManager(@Autowired entityManagerFactory: EntityManagerFactory): EntityManager {
        return entityManagerFactory.createEntityManager()
    }

    @Bean("transactionManager")
    fun transactionManager(@Autowired() entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }

    @Bean("hibernateAdapter")
    fun jpaVendorAdapter() : JpaVendorAdapter {
        val adapter =  HibernateJpaVendorAdapter()
        adapter.setDatabase(databaseType)
        adapter.setDatabasePlatform(orgHibernateDialect)
        adapter.setShowSql(showSql.toBoolean())
        adapter.setGenerateDdl(hibernateDDL.toBoolean())
        return adapter
    }

    companion object {
        const val oat_music = "oat_music"
    }

}