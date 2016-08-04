<div class="x_content">
	<table id="example"
		class="table table-striped responsive-utilities jambo_table">
		<thead>
			<tr class="headings">
				<th style="width: 90%;">Nome</th>
				<th class=" no-link last"><span class="nobr">Ações</span></th>
			</tr>
		</thead>

		<tbody>
			<g:each status="i" var="usuario" in="${lista}">
				<tr class="${ (i % 2) == 0 ? 'even pointer' : 'odd pointer'}">
					<td class=" ">
						${usuario.username}
					</td>
					<td class="last">
						<a href="javascript: visualizar(${usuario.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
						&nbsp;&nbsp;
						
						<a href="javascript: alterar(${usuario.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
						&nbsp;&nbsp;

						<a href="javascript: excluir(${usuario.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
					</td>
				</tr>
			</g:each>
		</tbody>

	</table>
</div>
