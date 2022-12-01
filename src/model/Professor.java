package model;

public class Professor {
    
    private int id;
    private String nome;
    private long cpf;
    private float salario;
    private String endereco;
    private int telefone;
    private int horasTrabalhadas;
    
    public Professor(int id, String nome, long cpf, float salario, String endereco, int telefone, int horasTrabalhadas){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public long getCpf(){
        return cpf;
    }
    
    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    
    public float getSalario(){
        return salario;
    }
    
    public void setSalario(float salario){
        this.salario = salario;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public int getTelefone(){
        return telefone;
    }
    
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    public int getHorasTrabalhadas(){
        return horasTrabalhadas;
    }
    
    public void setHorasTrabalhadas(int horasTrabalhadas){
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
}
