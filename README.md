# SpringMybatisDemo

## SpringMVC4 + MyBatis3 + ApacheTiles3 + SQLServer Demo

### データベース設定
自分のデータベース設定にあわせて修正すること(1433はSQLServerのデフォルトポート)

src/main/resources/jdbc.properties
```
url: jdbc:sqlserver://127.0.0.1:1433;DatabaseName=DataBaseName
username: username
password: password
```
### 初期テーブル作成  
src/main/sql/schema.sqlの中のDDLをSQLServerにて実行して、テーブルを作成しておく。  


### 起動＆確認  
Tomcat/JBossサーバに起動し終わったら、ブラウザを立ち上げて、以下のURLを入力する  
```
http://localhost:8080/SpringMyBatisDemo/book
```

