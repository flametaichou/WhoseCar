# WhoseCar

Маленький учебный проект для изучения технологий Spring, Hibernate, PostgreSQL, AngularJS и Liquibase. Задумывался как сервис для проверки принадлежности машин на стоянке жильцам дома.

![Preview](https://github.com/flametaichou/WhoseCar/blob/master/images/whosecar-preview.png?raw=true "Preview")

### Запуск
Нужно указать postgres базу данных и юзера в
```html
src/main/resources/application.properties
src/main/resources/META-INF/spring/beans.xml
```
после чего собрать приложение.
```html
mvn clean install
```
Собранный war-контейнер деплоится через tomcat.
