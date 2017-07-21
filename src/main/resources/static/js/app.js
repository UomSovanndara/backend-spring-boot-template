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
        .when('/',{
            templateUrl: 'partials/home.html'
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
        });

    // visual studio style
    $mdThemingProvider.theme('default')
        .primaryPalette('purple')
        .accentPalette('blue')
        .warnPalette('red')
        .backgroundPalette('grey');

    // google play store style

    /*
    $mdThemingProvider.theme('default')
        .primaryPalette('green')
        .accentPalette('blue')
        .warnPalette('green')
        .backgroundPalette('grey');
        */
});
