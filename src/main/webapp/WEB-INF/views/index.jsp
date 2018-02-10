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

<body>
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
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/admin/' />">Панель управления</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>

    <div class="empty-height"></div>
    <main role="main" class="inner cover text-white text-center">
          <h1 class="mt-5 greeting-text">WhoseCar - сервис для поиска владельца машины</h1>
          <p class="lead greeting-text">Для начала работы выберите один из пунктов меню</p>
          <br />
          <a class="btn btn-outline-light btn-lg mx-2" href="<c:url value='/search-car/' />">Искать по номеру машины</a>
          <a class="btn btn-outline-light btn-lg mx-2" href="<c:url value='/search-room/' />">Искать по номеру квартиры</a>
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
