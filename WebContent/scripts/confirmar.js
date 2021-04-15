/**
 * confirmar exclusão de contato
 *@author Henrique Correa de Lima
 */

function confirmar(id){
	let resposta = confirm("Tem certeza que deseja excluir este contato?")
	if (resposta === true){
		//alert(id)
		window.location.href = "delete?id=" + id
	}
}