<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="icon" href="favicon.ico" />

    <title>WhoseCar - сервис для определения владельца машины</title>

    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/sticky-footer-navbar.css' />" rel="stylesheet"></link>

    <style>
        body {
            background-repeat: no-repeat;
            background: #f5f5f5 url(<c:url value='/static/images/background.jpg' />) center fixed;
            background-size: cover;
        }
    </style>
</head>

<body ng-app="myApp" class="ng-cloak">
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="<c:url value='/' />">WhoseCar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/search-car/' />">По номеру</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value='/search-room/' />">По квартире <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="navbar-nav mt-2 mt-md-0">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/admin/' />">Панель управления</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>

    <main role="main" class="container text-white">
          <h1 class="mt-5">Поиск машин по номеру квартиры</h1>
          <p class="lead">Введите номер квартиры и получите список автомобилей, числящихся за жильцами</p>


          <div class="generic-container" ng-controller="AppController as ctrl" onload="ctrl.byRoomNumber()">
              <div class="input-group mb-3 input-group-lg">
                <input type="text" ng-model="roomnumber" class="form-control" placeholder="Введите номер квартиры" aria-label="Введите номер квартиры" aria-describedby="basic-addon2">
                <div class="input-group-append">
                  <button class="btn btn-primary" ng-click="ctrl.byRoomNumber()" ng-onload="ctrl.byRoomNumber()" type="submit">Искать</button>
                </div>
              </div>
              <div ng-if="ctrl.flag">
                  <div ng-if="ctrl.cars" class="panel panel-default">
                     <div class="panel-heading"><span class="lead">Результат:</span></div>
                         <div class="tablecontainer">
                             <table class="table table-hover text-white">
                                <thead>
                                    <tr>
                                        <th>Номер</th>
                                        <th>Марка</th>
                                        <th>Цвет</th>
                                        <th>Квартира</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="u in ctrl.cars">
                                        <td><span ng-bind="u.carNumber"></span></td>
                                        <td><span ng-bind="u.carBrand"></span></td>
                                        <td><span ng-bind="u.carColor"></span></td>
                                        <td><span ng-bind="u.room.roomNumber"></span></td>
                                    </tr>
                                </tbody>
                             </table>
                         </div>
                  </div>
              </div>
              <div ng-if="!ctrl.cars" class="alert alert-light" role="alert">Машин в квартире из вашего запроса не найдено!</div>
          </div>
    </main>


    <footer class="footer">
      <div class="container text-right">
        <span class="text-muted">WhoseCar 2018</span>
      </div>
    </footer>


    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/static/js/service/app_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/app_controller.js' />"></script>
</body>
</html>
