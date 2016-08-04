<div class="x_title">
	<h2>Cadastro</h2>
	<ul class="nav navbar-right panel_toolbox"></ul>
	<div class="clearfix"></div>
</div>

<div class="x_content">
	<br />
	
	<form id="form" class="form-horizontal form-label-left">

		<div class="form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="nome">Username *</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="nome" name="usuario.username" required="required" class="form-control col-md-7 col-xs-12" maxlength="50" value="${usuario.username}" <g:if test="${!editable}">disabled</g:if>/>
			</div>
		</div>

		<g:if test="${editable}">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12" for="nome">Password *</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="password" name="usuario.password" required="required" class="form-control col-md-7 col-xs-12" maxlength="50" />
				</div>
			</div>
		</g:if>

		<div class="form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="nome">Grupo *</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<g:if test="${editable}">
					<select	class="form-control" id="grupo" name="usuario.grupo" required="required" data-parsley-errors-container="#errorGrupo">
						<option value="">Selecione o Grupo</option>
						<g:each in="${grupos}" var="grp">
							<g:if test="${(usuario.grupo.id == grp.id)}">
								<option value="${grp.id}" selected="selected">
									${grp.nome}
								</option>
							</g:if>
							<g:else>
								<option value="${grp.id}">
									${grp.nome}
								</option>
							</g:else>
						</g:each>
					</select>
				</g:if>
				<g:else>
					<input type="text" name="usuario.grupo" required="required" class="form-control col-md-7 col-xs-12" maxlength="50" value="${usuario.grupo.nome}" disabled="disabled" />
				</g:else>
				<span id="errorGrupo"></span>
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

		<input type="hidden" name="id" value="${usuario.id}" />
		<input type="hidden" name="version" value="${usuario.version}" />

		<script type="text/javascript">
			$(document).ready(function() {
				<!-- form validation -->
				$("#form").parsley()

				$("#form").on( "submit", function( event ) {

					event.preventDefault()
					
					var dados = $(this).serialize()

					salvar(dados)

				})

				$("#grupo").select2()
				
				$("#nome").focus()
			});
		</script>
	</form>
</div>
