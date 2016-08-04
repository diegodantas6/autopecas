<div class="row">
	
	<div class="ln_solid"></div>
	
	<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		<div class="demo-section k-header">
			<label>Permissões</label>
			<div id="treeview"></div>
			<input id="result" name="result" type="hidden" />
		</div>
	</div>
</div>

<div class="form-group">
	<div class="ln_solid"></div>
	<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		<button type="submit" class="btn btn-primary" onclick="javascript: salvar()">Salvar</button>
		<button type="reset" class="btn btn-warning" onclick="javascript: cancelar()">Cancelar</button>
	</div>
</div>

<script>
	$("#treeview").kendoTreeView({
		checkboxes : {
			checkChildren : true
		},

		check : onCheck,

		dataSource : ${raw(retorno)}

	});

	// function that gathers IDs of checked nodes
	function checkedNodeIds(nodes, checkedNodes) {
		for (var i = 0; i < nodes.length; i++) {
			if (nodes[i].checked) {
				checkedNodes.push(nodes[i].id);
			}

			if (nodes[i].hasChildren) {
				checkedNodeIds(nodes[i].children.view(), checkedNodes);
			}
		}
	}

	// show checked node IDs on datasource change
	function onCheck() {
		var checkedNodes = [], treeView = $("#treeview").data("kendoTreeView"), message;

		checkedNodeIds(treeView.dataSource.view(), checkedNodes);

		if (checkedNodes.length > 0) {
			message = checkedNodes.join(",");
		} else {
			message = "";
		}

		$("#result").val(message);
	}

	onCheck();
</script>

<style>
	#treeview .k-sprite {
		background-image:
			url("${createLink(uri: '/assets/kendo/coloricons-sprite.png')}");
	}
	
	.rootfolder {
		background-position: 0 0;
	}
	
	.folder {
		background-position: 0 -16px;
	}
	
	.pdf {
		background-position: 0 -32px;
	}
	
	.html {
		background-position: 0 -48px;
	}
	
	.image {
		background-position: 0 -64px;
	}
</style>
