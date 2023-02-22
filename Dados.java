public class Dados {
    private Integer id;
    private String nome;
    private Double salario;

    public Dados(Integer id, String nome, Double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void aumento (Double perc){
        salario += salario*(perc/100);
    }

    @Override
    public String toString() {
        return  id +
                ", " + nome +
                ", " + String.format("%.2f", salario) ;
    }
}
