/**
 * Script criado para atender os cadastros padroes sem filtro
 */

$(document).ready(function() {

	carregarLista()

})

function carregarLista() {
	$("#divForm").hide()

	$.ajax({
		method : "POST",
		url : "listar",
		data : {},
		success : function(data) {
			$("#divLista").html(data)
			formatTable()
		},
		error : function(data) {
			retornoErro(data)
		}
	})
}

function excluir(id) {
	
	var sim = function () {
		$.ajax({
			method : "POST",
			url : "excluir",
			data : {
				"id" : id
			},
			success : function(data) {

				show(data.tipo, data.mensagem)

				if (data.tipo) {
					carregarLista()
				}
			},
			error : function(data) {
				retornoErro(data)
			}
		})
	}
	
	var nao = function () {}
	
	customConfirm('Deseja realmente excluir?', sim, nao)
}

function visualizar(id) {
	$.ajax({
		method : "POST",
		url : "visualizar",
		data : {
			"id" : id
		},
		success : function(data) {
			$("#divFormLista").hide()
			$("#divForm").show()
			$("#divForm").html(data)
		},
		error : function(data) {
			retornoErro(data)
		}
	})
}

function alterar(id) {
	$.ajax({
		method : "POST",
		url : "alterar",
		data : {
			"id" : id
		},
		success : function(data) {
			$("#divFormLista").hide()
			$("#divForm").show()
			$("#divForm").html(data)
		},
		error : function(data) {
			retornoErro(data)
		}
	})
}

function salvar(dados) {
	$.ajax({
		method : "POST",
		url : "salvar",
		data : dados,
		success : function(data) {
			retornoSalvar(data)
		},
		error : function(data) {
			retornoErro(data)
		}
	})
}

function retornoSalvar(data) {
	show(data.tipo, data.mensagem)

	if (data.tipo) {
		carregarLista()
		$("#divFormLista").show()
	}
}

function cancelar() {
	$("#divFormLista").show()
	$("#divForm").hide()
}

function incluir() {
	$.ajax({
		method : "POST",
		url : "incluir",
		data : {},
		success : function(data) {
			$("#divFormLista").hide()
			$("#divForm").show()
			$("#divForm").html(data)
		},
		error : function(data) {
			retornoErro(data)
		}
	})
}

function retornoErro(data) {

	if (data.status == 403) {

		show(false, "Entre em contato com o administrador para obter permissão")
		
		show(false, "Desculpe, você não possui autorização para realizar esta operação")
		
	} else {
		
		show(false, "Entre em contato com o administrador")
		
		show(false, "Desculpe, erro desconhecido")

	}

}
