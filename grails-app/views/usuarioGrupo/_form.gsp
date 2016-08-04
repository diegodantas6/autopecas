<div class="x_title">
	<h2>Cadastro</h2>
	<ul class="nav navbar-right panel_toolbox"></ul>
	<div class="clearfix"></div>
</div>

<div class="x_content">
	<br />
	
	<form id="form" class="form-horizontal form-label-left">

		<div class="form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="nome">Nome *</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="nome" name="usuarioGrupo.nome" required="required" class="form-control col-md-7 col-xs-12" maxlength="50" value="${usuarioGrupo.nome}" <g:if test="${!editable}">disabled</g:if>/>
			</div>
		</div>

		<div class="ln_solid"></div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">

				<g:if test="${editable}">
					<input type="submit" class="btn btn-primary" name="btnSalvar" value="Salvar" />
					<input type="button" class="btn btn btn-warning" name="btnCancelar" value="Cancelar" onclick="cancelar();" />
				</g:if>
				<g:else>
					<input type="button" class="btn btn btn-primary" name="btnVoltar" value="Voltar" onclick="cancelar();" />
				</g:else>

			</div>
		</div>

		<input type="hidden" name="id" value="${usuarioGrupo.id}" />
		<input type="hidden" name="version" value="${usuarioGrupo.version}" />

		<script type="text/javascript">
			$(document).ready(function() {
				<!-- form validation -->
				$("#form").parsley()

				$("#form").on( "submit", function( event ) {

					event.preventDefault()
					
					var dados = $(this).serialize()

					salvar(dados)

				})

				$("#nome").focus()
			});
		</script>
	</form>
</div>
