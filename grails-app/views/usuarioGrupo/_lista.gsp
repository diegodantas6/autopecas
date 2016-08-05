<div class="x_content">
	<table id="example"	class="table table-striped table-bordered jambo_table">
		<thead>
			<tr class="headings">
				<th style="width: 100%;">Nome</th>
				<th style="width: 80px;">Ações</th>
			</tr>
		</thead>

		<tbody>
			<g:each status="i" var="usuarioGrupo" in="${lista}">
				<tr class="${ (i % 2) == 0 ? 'even pointer' : 'odd pointer'}">
					<td class=" ">
						${usuarioGrupo.nome}
					</td>
					<td class="last">
						<a href="javascript: visualizar(${usuarioGrupo.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
						&nbsp;&nbsp;
						
						<a href="javascript: alterar(${usuarioGrupo.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
						&nbsp;&nbsp;

						<a href="javascript: excluir(${usuarioGrupo.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
					</td>
				</tr>
			</g:each>
		</tbody>

	</table>
</div>
