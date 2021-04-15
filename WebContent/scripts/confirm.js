/**
 * Confirmar exclusão de contato
 * @author Henrique Correa de Lima
 */

function confirmar(id){
	let resposta = confirm("Tem certeza que deseja excluir ?")
	if (resposta === true) {
		//alert(id)//teste de recebimento - receipt test
		window.location.href = "select?id=" + id
	}
}