# Oat-Music-Server

Server service for the oat music

### Run Postgres docker container
<hr>
docker run --name my-postgres  -p 5432:5432 -e POSTGRES_PASSWORD=12345 -e POSTGRES_USER=oat_music postgres


### Datasource配置
<hr>
主要配置參考檔案com/oatmusic/oat_music_server/web/config/DatasourceConfig.kt

###Test環境
<li>配置H2 DB, 環境變數SPRING_PROFILES_ACTIVE=test時讀取application-test.properties，其中含有h2 db的相關配置
<li>啟動時會讀取
    <p>schema_test.sql => 建立schema</p>
    <p>data_test       => 建立假資料</p>
</li>


###DEV環境
<hr>
dev配置postgresql DB, 環境變數SPRING_PROFILES_ACTIVE=dev時讀取application-dev.properties，預設讀取dev

DEV的postgres的相關設定如下，如果有更改docker啟動時的參數，以下也要進行修改
<li>url: jdbc:postgresql://localhost:5432/oat_music</li>
<li>username: oat_music</li>
<li>passowrd: 12345</li>

### LOG設定
<hr>
請參照logback.xml => 從網上copy來的，歡迎各路大神修改
目前log存放位置：logs/myLogger.yyyymmdd

