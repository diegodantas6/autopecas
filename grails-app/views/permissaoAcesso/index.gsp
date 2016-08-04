<head>
<meta name="layout" content="gentelella">

<!-- Kendo -->
<asset:stylesheet href="kendo/kendo.common-material.min.css" />
<asset:stylesheet href="kendo/kendo.material.min.css" />
<asset:javascript src="kendo/kendo.all.min.js" />

<asset:javascript src="permissaoAcesso.js"/>
</head>

<body>
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>Permissão Acesso</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="form-group">
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<label>Grupo Usuário</label>
							<select class="form-control" onchange="carregaTreeView();" id="grupoUsuario" name="grupoUsuario" required="required">
								<option value="0" selected>Selecione o Grupo Usuário</option>
								<g:each in="${grupos}" var="grupo">
									<option value="${grupo.id}">
										${grupo.nome}
									</option>
								</g:each>
							</select>
						</div>
					</div>
					<div id="divForm"></div>
				</div>
			</div>
		</div>
	</div>
</body>
