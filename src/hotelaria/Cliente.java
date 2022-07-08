package hotelaria;

import java.util.Date;


public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private Date data_nasc;

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
    
    public void CadastroCliente (){
        System.out.println("informe o id ");
        id = Input.nextInt();
        System.out.println("informe o nome ");
        nome = Input.nextLine();
        System.out.println("informe o cpf");
        cpf = Input.nextLine();
        System.out.println("informe o rg");
        rg = Input.nextLine();
        System.out.println("informe o telefone ");
        telefone = Input.nextLine();
        System.out.println("informe a data de nascimento");
        data_nasc = Input.nextDate();
        
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone + ", data_nasc=" + data_nasc + '}';
    }
    
    
}
