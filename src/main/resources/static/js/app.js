var dependency = [
    'ngAria',
    'ngRoute',
    'ngMessages',
    'ngAnimate',
    'ngSanitize',
    'ngMaterial',
    'ngMdIcons'
];
angular.module("adminApp", dependency).config(function($routeProvider, $mdThemingProvider){
    $routeProvider
        .when('/dashboard',{
            templateUrl: 'partials/dashboard.html'
        })
        .when('/about',{
            templateUrl:'partials/about.html'
        })
        .when('/contact',{
            templateUrl:'partials/contact.html'
        })
        .when('/products',{
            templateUrl:'partials/products.html'
        })
        .when('/login',{
            templateUrl:'partials/login.html',
            controller : 'LoginCtrl'
        })
        .when('/register',{
            templateUrl:'partials/register.html',
            controller : 'RegisterCtrl'
        })
        .when('/home',{
            templateUrl:'partials/home.html'
        })
        .when('/users',{
            templateUrl:'partials/user.html',
            controller : 'UserCtrl'
        })
        .otherwise({
            redirectTo: '/login'
        });

    // visual studio style
    /*
    $mdThemingProvider.theme('default')
        .primaryPalette('purple')
        .accentPalette('blue')
        .warnPalette('red')
        .backgroundPalette('grey');
    */
    // google play store style


    $mdThemingProvider.theme('default')
        .primaryPalette('green')
        .accentPalette('blue')
        .warnPalette('green')
        .backgroundPalette('grey');

}).run(function($rootScope, $location) {
    /*
    $rootScope.$on( "$routeChangeStart", function(event, next, current) {
        if ($rootScope.loggedInUser == null) {
            // no logged user, redirect to /login
            if ( next.templateUrl === "partials/login.html") {

            } else {
                $location.path("/login");
            }
        }
    });
    */
}).controller('AppCtrl', function($scope, $log, $mdSidenav, $location) {
    $scope.toShow = "home";
    $scope.languageIcon = 'language';
    $scope.clickIcon = 'add';

    $scope.toggleMenu = function() {
        $mdSidenav('left').toggle();
    };

    $scope.openMenu = function($mdOpenMenu, event) {
        $mdOpenMenu(event);
    };

    $scope.clickIconMorph = function() {
        if ($scope.clickIcon === 'add') {
            $scope.clickIcon = 'menu';
        } else {
            $scope.clickIcon = 'add';
        }
    };
    $scope.show = function (toShow) {
        $location.url(toShow);
    };
});
