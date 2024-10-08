import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String csvFile = "csvDemo.csv";
        Matriz labirinto = CSVReader.read(csvFile);


        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a linha da entrada: ");
        int linhaEntrada = sc.nextInt();
        System.out.println("Digite a coluna da entrada: ");
        int colunaEntrada = sc.nextInt();

        System.out.println("Digite a linha da saída: ");
        int linhaSaida = sc.nextInt();
        System.out.println("Digite a coluna da saída: ");
        int colunaSaida = sc.nextInt();

        
        ArrayList<Integer> caminho_linha = new ArrayList<Integer>();
        ArrayList<Integer> caminho_coluna = new ArrayList<Integer>();

        boolean caminhoEncontrado = labirinto.encontrarCaminho(linhaEntrada, colunaEntrada, linhaSaida, colunaSaida,caminho_linha, caminho_coluna);

        if (caminhoEncontrado) {
            System.out.println("Caminho encontrado:");
            labirinto.print();
        } else {
            System.out.println("Nenhum caminho foi encontrado.");
        }

        sc.close();
    }
}
