package model;

public class Funcionario {
    private int id;
    private String nome;
    private String funcao;
    private float salario;
    private String endereco;
    private long telefone;

    public Funcionario(int id, String nome, String funcao, float salario, String endereco, long telefone) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Funcionario(String nome, String funcao, float salario, String endereco, long telefone) {
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
        this.endereco = endereco;
        this.telefone = telefone;
    }
        
    public Funcionario(int id, String nome, String funcao){
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
    }

    public Funcionario(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
       
}
