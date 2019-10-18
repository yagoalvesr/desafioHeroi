angular.module("heroi").controller("jogadorCtrl", function ($scope, jogadorService) {
	var vm = this;
	vm.app = "Heróis";
	vm.service = jogadorService;
	vm.jogador = {};

	vm.init = function(){
		vm.login = true;
		vm.carregarHerois();
	}

	vm.carregarHerois = function () {
		vm.service.getHerois().success(function (data) {
			vm.herois = data;
		}).error(function (data, status) {
			vm.message = "Aconteceu um problema: " + data;
		});
	};

	vm.irCadastrar = function () {
		vm.cadastrar = true;
		vm.login = false;
	}

	vm.irLogin = function () {
		vm.login = true;
		vm.cadastrar = false;
	}
});