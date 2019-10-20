angular.module("heroi").controller("heroiCtrl",
		function($scope, heroisService) {
			var vm = this;
			vm.app = "Heróis";
			vm.service = heroisService;
			vm.vencedor = {
				nickname : null
			}
			vm.herois = [];

			vm.listJogadores = [];

			vm.init = function() {
				vm.login = true;
				vm.carregarHerois();
			}

			vm.irCadastrar = function() {
				
				vm.message = null;

				vm.cadastrar = true;
				vm.login = false;
			}
			
			vm.voltarParaLogin = function(){
				
				vm.vencedor = null;
				vm.jogador = null;
				vm.login = true;
				vm.cadastrar = false;
				vm.batalha = false;
				
				vm.message = null;
			}

			vm.irLogin = function(user) {
				
				vm.message = null;

				vm.service.fazerLogin(user).success(function(data) {

					vm.user = data;
					vm.carregarJogadores();

					console.log("Deu certo");
					
					vm.batalha = true;
					vm.login=false;

				}).error(function(data, status) {
					console.log("Deu erro");
					vm.message = "Aconteceu um problema: " + data.mensagem;
				});

			}

			vm.irResultado = function(jogador) {
				
				vm.message = null;

				vm.service.resultadoBatalha(jogador, vm.user).success(function(data) {
					console.log(vm.user);
					console.log("Deu certo");
					vm.vencedor = data;
					
					vm.message = ("Vencedor" + vencedor.nickname);


					console.log(vm.resultado);
				}).error(function(data, status) {
					console.log("Deu erro");
					vm.message = "Aconteceu um problema: " + data;
				});

			}

			vm.cadastrarJogador = function(user) {
				
				vm.message = null;

				vm.service.cadastrarJogador(user).success(function(data) {
					
					vm.message = "Cadastro realizado com sucesso"
						
					console.log("Deu certo");
				}).error(function(data, status) {
					console.log("Deu erro");
					vm.message = "Aconteceu um problema: " + data.mensagem;
				});
			}

			vm.carregarHerois = function() {
				vm.service.getHerois().success(function(data) {
					vm.herois = data;
				}).error(function(data, status) {
					vm.message = "Aconteceu um problema: " + data;
				});
			};

			vm.carregarJogadores = function() {
				vm.service.getJogadores().success(function(data) {
					vm.listJogadores = data;
				}).error(function(data, status) {
					vm.message = "Aconteceu um problema: " + data;
				});
			};
		});