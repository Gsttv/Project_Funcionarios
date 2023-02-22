import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionarios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de funcnionarios:");
        int qnt = sc.nextInt();
        List<Dados> funcionario = new ArrayList<>();
        for (int i=0 ; i<qnt; i++){
            System.out.println("Digite os dados do funcionario "+i);
            System.out.println("ID");
            int id = sc.nextInt();
            while (idExistente(funcionario,id)){
                System.out.println("ID EXISTENTE, DIGITE NOVAMENTE");
                id = sc.nextInt();
            }
            System.out.println("NOME");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.println("SALARIO");
            double salario = sc.nextDouble();
            Dados func = new Dados(id,nome,salario);
            funcionario.add(func);
        }
        System.out.println("Digite o id do funcionario que receberá o aumento");
        int id_funcionario = sc.nextInt();
        System.out.println("Digite a porcentagem de aumento");
        double perc = sc.nextDouble();
        Dados busca_id = funcionario.stream().filter(x -> x.getId()== id_funcionario).findFirst().orElse(null);
        boolean a = false;
        while (a==false){ //NÃO ESTA FUNCIONADO, LOOP INFINITO.
            busca_id = funcionario.stream().filter(x -> x.getId()== id_funcionario).findFirst().orElse(null);
            if (busca_id != null) {
                busca_id.aumento(perc);
                a = true;
            } else {
                System.out.println("ID NÃO EXISTE, DIGITE UM ID VALIDO");
            }
        }
        System.out.println("LISTA DE FUNCIOANRIOS");
        for (Dados e : funcionario) {
            System.out.println(e);
        }

        sc.close();
    }
    public static boolean idExistente(List<Dados> lista, int id){
        Dados teste = lista.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
        return teste != null;

    }
}
