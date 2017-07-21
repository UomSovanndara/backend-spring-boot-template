angular
	.module('adminApp')
    .controller('LoginCtrl', function($scope){
        $scope.vm = {
            formData: {
                email: 'hello@patternry.com',
                password: 'foobar'
            }
        };

    });