JDK Oracle 21\
Spring 3.2.2\
Maven

## Инструкция по запуску
Перед запуском необходимо убедиться, что установлен JDK Oracle 21.

### Запуск в docker:
1. Перейдите в директорию приложения ~\demo
2. Выполниете команду _mvnw package_
3. Выполниете команду _docker build -t demo-test-app ._
4. Выполниете команду _docker run -d -p 8080:8080 -t demo-test-app_

### Запуск из консоли:
1. Перейдите в директорию приложения ~\demo
2. Выполниете команду _mvnw package_
3. Перейдите в папку с билдом ~\demo\target
4. Выполниете команду _java -jar demo-0.0.1-SNAPSHOT.jar_

После запуска приложение будет ожидать POST запрос с URL http://localhost:8080/getCountFromFullStringWithDescendingOrder в теле которого должны быть входящие параметры в формате JSON

## О приложении
Формат входящих параметров JSON:
```json
{
  "data": "string"
}
```
Синтаксис входящих параметров соответсвует документации [JSON](https://www.json.org/json-en.html) \
[Более читабельный пример](https://learn.microsoft.com/ru-ru/sql/relational-databases/json/how-for-json-escapes-special-characters-and-control-characters-sql-server?view=sql-server-ver16)

### Ограничения
- Поле data не может быть null
- Тело запроса не может быть пустым

### Формат исходящих параметров:
Пример тела ответа:
```json
{
    "f": 5,
    "e": 4,
    "d": 3,
    "c": 2,
    "a": 1
}
```

### Коды ответов:
- При корректной работе приложения возвращается **200** ОК
- При передаче data:null возвращается **400** BAD_REQUEST с message:"Json data is null"
- При пустом теле запроса возвращается **415** "Unsupported Media Type"

