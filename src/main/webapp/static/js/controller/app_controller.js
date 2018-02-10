'use strict';

angular.module('myApp').controller('AppController', ['$scope', 'AppService', function($scope, AppService) {
    var self = this;
    self.car={id:null,carNumber:'',carBrand:'',carColor:'',room:''};
    self.cars=[];
    self.room={id:null,roomNumber:'',cars:null};
    $scope.carnumber='';
    self.flag=false;

    $scope.admincarnumber='';
    $scope.admincarbrand='';
    $scope.admincarcolor='';

    $scope.adminroomnumber='';

    $scope.adminbindcar='';
    $scope.adminbindroom='';
    self.carroom={carNumber:'',roomNumber:''};

    $scope.admindelcarnumber='';
    $scope.admindelroomnumber='';

    self.byCarNumber = byCarNumber;
    self.byRoomNumber = byRoomNumber;
    self.addCar = addCar;
    self.addRoom = addRoom;
    self.deleteCar = deleteCar;
    self.deleteRoom = deleteRoom;
    self.bindCarRoom = bindCarRoom;
    self.unbindCarRoom = unbindCarRoom;

    fetchAllCars();

    function fetchAllCars(){
        AppService.fetchAllCars()
            .then(
            function(d) {
                self.cars = d;
            },
            function(errResponse){
                self.cars = null;
            }
        );
    }

    function fetchCarsByCarNumber(){
        self.flag=true;
        AppService.fetchByCarNumber($scope.carnumber)
            .then(
            function(d) {
                self.cars = d;
            },
            function(errResponse){
                self.cars = null;
            }
        );
    }

    function fetchCarsByRoomNumber(){
        self.flag=true;
        AppService.fetchByRoomNumber($scope.roomnumber)
            .then(
            function(d) {
                self.cars = d;
            },
            function(errResponse){
                self.cars = null;
            }
        );
    }

    function byCarNumber(){
        if ($scope.carnumber == '') {
          self.cars = null;
        } else {
          fetchCarsByCarNumber()
        }
        $scope.myForm.$setPristine();
    }

    function byRoomNumber(){
        if ($scope.roomnumber == '') {
          self.cars = null;
        } else {
          fetchCarsByRoomNumber()
        }
        $scope.myForm.$setPristine();
    }

    function addCar(){
        if ($scope.admincarnumber != '' && $scope.admincarbrand != '' && $scope.admincarcolor != '') {
            self.car = {id:null,carNumber:$scope.admincarnumber, carBrand:$scope.admincarbrand, carColor:$scope.admincarcolor,room:null};
            AppService.addCar(self.car)
                .then(
                function(d) {
                    alert("Добавлено! " + d);
                },
                function(errResponse){
                    alert("Ошибка! " + errResponse);
                }
            );
        } else {
            alert("Заполните все поля!")
        }
    }

    function addRoom(){
        if ($scope.adminroomnumber != '') {
            self.room = {id:null,roomNumber:$scope.adminroomnumber,cars:null};
            AppService.addRoom(self.room)
                .then(
                function(d) {
                    alert("Добавлено! " + d);
                },
                function(errResponse){
                    alert("Ошибка! " + errResponse);
                }
            );
        } else {
            alert("Заполните поле!")
        }
    }

    function bindCarRoom(){
        if ($scope.adminbindcar != '' && $scope.adminbindroom != '') {
            self.carroom = {carNumber:$scope.adminbindcar,roomNumber:$scope.adminbindroom};
            AppService.bindCarRoom(self.carroom)
                .then(
                function(d) {
                    alert("Добавлено! " + d);
                },
                function(errResponse){
                    alert("Ошибка! " + errResponse);
                }
            );
        } else {
            alert("Заполните все поля!")
        }
    }

    function unbindCarRoom(){
        if ($scope.adminbindcar != '' && $scope.adminbindroom != '') {
            self.carroom = {carNumber:$scope.adminbindcar,roomNumber:$scope.adminbindroom};
            AppService.unbindCarRoom(self.carroom)
                .then(
                function(d) {
                    alert("Добавлено! " + d);
                },
                function(errResponse){
                    alert("Ошибка! " + errResponse);
                }
            );
        } else {
            alert("Заполните все поля!")
        }
    }

    function deleteCar(){
        if ($scope.admindelcarnumber != '') {
            AppService.deleteCar($scope.admindelcarnumber)
                .then(
                function(d) {
                    alert("Добавлено! " + d);
                },
                function(errResponse){
                    alert("Ошибка! " + errResponse);
                }
            );
        } else {
            alert("Заполните поле!")
        }
    }

    function deleteRoom(){
        if ($scope.admindelroomnumber != '') {
            AppService.deleteRoom($scope.admindelroomnumber)
                .then(
                function(d) {
                    alert("Добавлено! " + d);
                },
                function(errResponse){
                    alert("Ошибка! " + errResponse);
                }
            );
        } else {
            alert("Заполните поле!")
        }
    }

}]);
