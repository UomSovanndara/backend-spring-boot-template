angular
	.module('adminApp')
	.controller('MenuCtrl', function($scope, $log, $mdSidenav, $location) {
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