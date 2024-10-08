
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Labirinto extends JFrame {
    private int[][] labirinto;
    private JPanel[][] cells;
    private int playerRow, playerCol;
    private Random random = new Random();

    public Labirinto(int[][] labirinto) {
        this.labirinto = labirinto;
        this.cells = new JPanel[labirinto.length][labirinto[0].length];
        initUI();
        encontrarCaminho(0,0);
    }

    private void initUI() {
        // Configuração da janela e layout
        setTitle("Labirinto com Animação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(labirinto.length, labirinto[0].length));

        // Inicializa o labirinto gráfico
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                cells[i][j] = new JPanel();
                if (labirinto[i][j] == 0) {
                    cells[i][j].setBackground(Color.BLACK); // Paredes são pretas
                } else {
                    cells[i][j].setBackground(Color.WHITE); // Passagens são brancas
                }
                add(cells[i][j]);
            }
        }

        // Define a posição inicial do "jogador" em uma passagem aleatória
       // do {
          //  playerRow = random.nextInt(labirinto.length);
        //    playerCol = random.nextInt(labirinto[0].length);
      //  } while (labirinto[playerRow][playerCol] == 0); // Garante que o "jogador" comece em uma passagem
        // define a posição inicial como (0,0)
        playerRow = 0;
        playerCol = 0;
        cells[playerRow][playerCol].setBackground(Color.RED); // Cor do "jogador"
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public boolean isValid(int linha, int coluna) {
        if (linha < 0 || coluna < 0 || linha >= labirinto.length || coluna >= labirinto[0].length) {
            return false;
        }
        return true;

    }


    public boolean encontrarCaminho(int linhaAtual, int colunaAtual) {

        int linhaSaida=labirinto.length;
        int colunaSaida=labirinto[0].length;

        if (linhaAtual == linhaSaida && colunaAtual == colunaSaida) {
            moverJogador(linhaAtual, colunaAtual);
            return true;
        }


        if (!isValid(linhaAtual, colunaAtual)) {
            return false;
        }

        moverJogador(linhaAtual, colunaAtual);
        
        int[] deltaLinha = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] deltaColuna = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int novaLinha = linhaAtual + deltaLinha[i];
            int novaColuna = colunaAtual + deltaColuna[i];


            if (encontrarCaminho(novaLinha, novaColuna)) {
                return true;
            }
        }


        moverJogador(linhaAtual, colunaAtual);

        return false;
    }



    private void moverJogador(int novaLinha, int novaColuna) {
        // Escolhe uma direção aleatória: 0 = cima, 1 = baixo, 2 = esquerda, 3 = direita
        
        // Verifica se a nova posição está dentro dos limites e se não é uma parede
        if (novaLinha >= 0 && novaLinha < labirinto.length &&
            novaColuna >= 0 && novaColuna < labirinto[0].length &&
            labirinto[novaLinha][novaColuna] == 1) {

            // Remove o jogador da posição atual
            cells[playerRow][playerCol].setBackground(Color.WHITE);

            // Move o jogador para a nova posição
            playerRow = novaLinha;
            playerCol = novaColuna;
            cells[playerRow][playerCol].setBackground(Color.RED);
        }
    }

    // Método para criar um exemplo de labirinto
    public static int[][] criarLabirinto() {
        String csvFile = "csvDemo.csv";
        return CSVReader.read(csvFile);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Labirinto lab = new Labirinto(criarLabirinto());
        });
    	// Labirinto lab = new Labirinto(criarLabirinto());
    }
}

