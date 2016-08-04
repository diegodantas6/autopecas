
$(document).ready(function() {

	$("#grupoUsuario").select2();

	carregaTreeView();

})

function retornoSalvar(data) {
	show(data.tipo, data.mensagem);

	carregaTreeView()
}

function carregaTreeView() {
	var id = $("#grupoUsuario").val()
	$("#divForm").hide()

	if (id > 0) {
		$.ajax({
			type : 'POST',
			data : 'id=' + id,
			url : 'carregaTreeView',
			success : function(data, textStatus) {
				$("#divForm").html(data)
				$("#divForm").show()
			}
		});
	}
}

function cancelar() {
	carregaTreeView()
}

function salvar() {
	var grupoUsuario = $("#grupoUsuario").val()
	var result = $("#result").val()

	if (grupoUsuario > 0) {
		$.ajax({
			type : 'POST',
			data : 'grupoUsuario=' + grupoUsuario + '&result=' + result,
			url : 'save',
			success : function(data, textStatus) {
				retornoSalvar(data)
			}
		});
	}
}
