'use strict';

angular.module('myApp').factory('AppService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/WhoseCar/rest/';

    var factory = {
        fetchAllCars: fetchAllCars,
        fetchByCarNumber: fetchByCarNumber,
        fetchByRoomNumber: fetchByRoomNumber,
        addCar: addCar,
        addRoom: addRoom,
        deleteCar: deleteCar,
        deleteRoom: deleteRoom,
        bindCarRoom: bindCarRoom,
        unbindCarRoom: unbindCarRoom
    };

    return factory;

    function fetchAllCars() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                alert('Ошибка при получении списка машин');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchByCarNumber(number) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/carnumber/", number)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при получении списка машин по номеру');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchByRoomNumber(number) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/roomnumber/", number)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при получении списка машин по номеру квартиры');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function addCar(data) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/addcar/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при добавлении новой машины');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function addRoom(data) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/addroom/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при добавлении новой квартиры');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function bindCarRoom(data) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/bind/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при связывании машины с квартирой');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function unbindCarRoom(data) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/unbind/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при отвязывании машины от квартиры');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteCar(data) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/deletecar/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при удалении машины');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteRoom(data) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"/deleteroom/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Ошибка при удалении квартиры');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


}]);
