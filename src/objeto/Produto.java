package objeto;

public class Produto {
	private String codigo;
	private String descricao;
	private String qtd;
	private String preco;
	
	public Produto(String codigo, String descricao, String qtd, String preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.qtd = qtd;
		this.preco = preco;
	}
	
	public Produto() {
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getQtd() {
		return qtd;
	}
	public void setQtd(String qtd) {
		this.qtd = qtd;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}
