angular.module("heroi").factory("heroisService", function ($http) {
	var baseUrl = 'http://localhost:8080/curso-hackaton-cdi/heroi';
	
	var _getHerois = function () {
		return $http.get(baseUrl);
	};
	
	var _getJogadores = function () {
		return $http.get("http://localhost:8080/curso-hackaton-cdi/jogador");
	};
	
	var _cadastrarJogador = function (user) {
		
		let novoUser= {
			nickname: user.nickname,
			senha: user.senha
		}
		
		console.log(user.heroi.id);
		
		return $http.post("http://localhost:8080/curso-hackaton-cdi/jogador/cadastrar/" + user.heroi.id, novoUser);
	};
	
	var _fazerLogin = function (user) {
		
		console.log(user.nickname);
		console.log(user.senha);
						
		return $http.get("http://localhost:8080/curso-hackaton-cdi/jogador/" + user.nickname +"/" + user.senha);
	};
	
	var _resultadoBatalha = function (jogador, user){
		
		console.log(user.nickname)
		
		console.log(jogador.nickname);
		
		return $http.get("http://localhost:8080/curso-hackaton-cdi/batalha/" + jogador.nickname + "/" + user.nickname);
	}

	return {
		getHerois: _getHerois,
		cadastrarJogador: _cadastrarJogador,
		fazerLogin: _fazerLogin,
		getJogadores: _getJogadores,
		resultadoBatalha: _resultadoBatalha
	};	
});