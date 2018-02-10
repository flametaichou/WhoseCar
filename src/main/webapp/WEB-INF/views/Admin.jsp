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
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/search-room/' />">По квартире</a>
            </li>
          </ul>
          <ul class="navbar-nav mt-2 mt-md-0">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value='/admin/' />">Панель управления <span class="sr-only">(current)</span></a>
            </li>
          </ul>
        </div>
      </nav>
    </header>

    <main role="main" class="container text-white">
    <div class="generic-container" ng-controller="AppController as ctrl">
          <div class="d-flex justify-content-between align-items-center">
              <h1 class="mt-5 greeting-text">Панель управления</h1>
              <a class="btn btn-outline-light btn-lg mx-2" href="<c:url value='/cars-list/' />">Все машины</a>
          </div>
          <hr class="double" />
          <p class="lead">Добавление новой машины</p>
                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control" ng-model="admincarnumber" id="carNumber" placeholder="Номер" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                             </div>
                                           </div>

                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control"  ng-model="admincarbrand" id="carBrand" placeholder="Марка" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                             </div>
                                           </div>

                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <select class="custom-select" ng-model="admincarcolor" id="carColor">
                                                 <option value="red">Красный</option>
                                                 <option value="blue">Синий</option>
                                                 <option value="green">Зеленый</option>
                                                 <option value="white">Белый</option>
                                                 <option value="black">Черный</option>
                                               </select>
                                             </div>
                                             <div class="col-md-6 mb-3">
                                                <button class="btn btn-primary float-right" ng-click="ctrl.addCar()">Добавить машину</button>
                                             </div>
                                           </div>
          <hr class="double" />
          <p class="lead">Добавление новой квартиры</p>

                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control"  ng-model="adminroomnumber" id="roomNumber" placeholder="Номер" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                                <button class="btn btn-primary float-right" ng-click="ctrl.addRoom()">Добавить квартиру</button>
                                             </div>
                                           </div>
          <hr class="double" />
          <p class="lead">Привязка машины к квартире</p>
                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control" ng-model="adminbindcar" id="carNumber" placeholder="Номер машины" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                                <button class="btn btn-primary float-right" ng-click="ctrl.bindCarRoom()">Привязать машину к квартире</button>
                                             </div>
                                           </div>

                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control"  ng-model="adminbindroom" id="roomNumber" placeholder="Номер квартиры" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                                <button class="btn btn-primary float-right" ng-click="ctrl.unbindCarRoom()">Отвязать машину от квартиры</button>
                                             </div>
                                           </div>
          <hr class="double" />
          <p class="lead">Удаление машины</p>

                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control"  ng-model="admindelcarnumber" id="carNumber" placeholder="Номер" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                                <button class="btn btn-primary float-right" ng-click="ctrl.deleteCar()">Удалить машину</button>
                                             </div>
                                           </div>
          <hr class="double" />
          <p class="lead">Удаление квартиры</p>

                                           <div class="row">
                                             <div class="col-md-6 mb-3">
                                               <input type="text" class="form-control"  ng-model="admindelroomnumber" id="roomNumber" placeholder="Номер" value="" required="">
                                             </div>
                                             <div class="col-md-6 mb-3">
                                                <button class="btn btn-primary float-right" ng-click="ctrl.deleteRoom()">Удалить квартиру</button>
                                             </div>
                                           </div>
          <hr class="double" />
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
