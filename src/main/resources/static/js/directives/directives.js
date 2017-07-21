(function() {
"use strict";

angular
    .module('adminApp')
    .directive('boMenu', function ggMenu() {
        return {
            templateUrl: "js/directives/menu.html",
            scope: {
                isTopLevelMenu: "=",
                pageName: "@"
            },
            controller : 'MenuCtrl'
        };
    });
}());
