package beans;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.Sexo;

@ManagedBean
@SessionScoped
public class CadastroPessoasBean {

	private Pessoa pessoaSelecionada;
	private Collection<Pessoa> lista;
	private String tipoNovaPessoa;
	
	public CadastroPessoasBean() {
		pessoaSelecionada = new PessoaFisica();
		lista = new ArrayList<Pessoa>();
		
		for (int x = 0; x < 10; x++){
			
			Pessoa p = (x%2==0) ? new PessoaFisica() : new PessoaJuridica();
			
			p.setNome(String.format("Fulano %02d", x));
			p.setEmail(String.format("Fulano@fulano.com", x));
			p.setTelefone(String.format("(12) 11111-22 %02d", x));
		
			lista.add(p);
		}
	}
	
	public void criar(){
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if (tipoNovaPessoa == null){
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Voc� deve especificar o tipo", ""));
			return;
		}
		
		if (tipoNovaPessoa.equals("PF")) {
			pessoaSelecionada = new PessoaFisica();
		} else if (tipoNovaPessoa.equals("PJ")){
			pessoaSelecionada = new PessoaJuridica();
		}
		
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa criada com sucesso!", ""));
	}

	public void salvar() {
		
		if (!lista.contains(pessoaSelecionada)) {
			lista.add(pessoaSelecionada);
		}
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Edi��o efetuada com sucesso!", ""));
		
	}

	public void excluir() {
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa exclu�da com sucesso!", ""));;
	}

	public String cancelar() {
		pessoaSelecionada = null;
		return "primeiro.jsf";
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public Collection<Pessoa> getLista() {
		return lista;
	}

	public void setLista(Collection<Pessoa> lista) {
		this.lista = lista;
	}

	public String getTipoNovaPessoa() {
		return tipoNovaPessoa;
	}

	public void setTipoNovaPessoa(String tipoNovaPessoa) {
		this.tipoNovaPessoa = tipoNovaPessoa;
	}
	
	/**
	 * 
	 * @return
	 * M�todos getters de atributos inexistentes
	 */
	public Sexo[] getSexos(){
		return Sexo.values();
	}
	
	public boolean isPessoaFisicaSelecionada(){
		return pessoaSelecionada instanceof PessoaFisica;
	}
	
	public boolean isPessoaJuridicaSelecionada(){
		return pessoaSelecionada instanceof PessoaJuridica;
	}
}
