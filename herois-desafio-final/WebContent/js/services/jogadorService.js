angular.module("heroi").factory("jogadorService", function ($http) {
	var baseUrl = 'http://localhost:8080/curso-hackaton-cdi/jogador';
	var _getHerois = function () {
		return $http.get(baseUrl);
	};

	return {
		getHerois: _getHerois
	};	
});