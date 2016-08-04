
$(document).ready(function() {
	
	var showSpinner = function() {
		$('#spinner').modal({
			backdrop: 'static'
		})
	}

	var closeSpinner = function() {
		$('#spinner').modal('hide')
	}
	
	$(document).on("ajaxSend", showSpinner).on("ajaxStop", closeSpinner).on("ajaxError", closeSpinner)
})

function customConfirm(texto, yesFunc, noFunc) {
	$.confirm({
		confirmButton : 'Confirmar',
		cancelButton : 'Cancelar',
		confirmButtonClass : 'btn-primary',
		cancelButtonClass : 'btn-danger',
		keyboardEnabled : true,
		title : 'Autopeças',
		icon : 'glyphicon glyphicon-ok',
		content : texto,

		confirm : function() {
			yesFunc()
		},
		cancel : function() {
			noFunc()
		}
	});
}

function show(valor, texto) {
	if (valor == true) {
		new PNotify({
			title : 'Sucesso',
			text : texto,
			type : 'success',
			delay: 3000,
			styling: 'bootstrap3'
		});
	} else {
		new PNotify({
			title : 'Erro',
			text : texto,
			type : 'error',
			delay: 3000,
			styling: 'bootstrap3'
		});
	}
}

function formatTable() {
	$('#example').dataTable({
		"oLanguage" : {
			"sSearch" : " "
		},
		"aoColumnDefs" : [{
			'bSortable' : false,
			'aTargets' : [ -1 ]
		}],
		"aaSorting": [],
		"sPaginationType" : "full_numbers"
	});
}
