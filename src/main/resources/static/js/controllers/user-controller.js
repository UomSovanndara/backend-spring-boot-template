var app = angular.module('adminApp');
app.controller('UserCtrl', function($scope) {
    $scope.user = {
        name: 'John Doe',
        email: '',
        phone: '',
        address: 'Mountain View, CA',
        donation: 19.99
    };
});