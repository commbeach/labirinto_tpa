import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Labirinto extends JFrame {
    private int[][] labirinto;
    private JPanel[][] cells;
    private int playerRow, playerCol;
    private Stack<Point> caminho = new Stack<>();

    public Labirinto(int[][] labirinto) {

        this.labirinto = labirinto;
        this.cells = new JPanel[labirinto.length][labirinto[0].length];
        initUI();
        new Thread(() -> {
            if (encontrarCaminho(0, 0)) {
                exibirCaminhoFinal();
            } else {
                System.out.println("Caminho não encontrado!");
            }
        }).start();
    }

    private void initUI() {
        setTitle("Labirinto Trabalho TPA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(labirinto.length, labirinto[0].length));

        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                cells[i][j] = new JPanel();
                if (labirinto[i][j] == 0) {
                    cells[i][j].setBackground(Color.BLACK);
                } else {
                    cells[i][j].setBackground(Color.WHITE);
                }
                add(cells[i][j]);
            }
        }

        playerRow = 0;
        playerCol = 0;
        cells[playerRow][playerCol].setBackground(Color.RED);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public boolean isValid(int linha, int coluna) {
        if (linha < 0 || coluna < 0 || linha >= labirinto.length || coluna >= labirinto[0].length) {
            return false;
        }
        return labirinto[linha][coluna] == 1;
    }

    public boolean encontrarCaminho(int linhaAtual, int colunaAtual) {

        int linhaSaida = labirinto.length - 1;
        int colunaSaida = labirinto[0].length - 1;

        if (linhaAtual == linhaSaida && colunaAtual == colunaSaida) {
            caminho.push(new Point(linhaAtual, colunaAtual));
            moverJogador(linhaAtual, colunaAtual);
            return true;
        }

        if (!isValid(linhaAtual, colunaAtual)) {
            return false;
        }

        labirinto[linhaAtual][colunaAtual] = 0;
        caminho.push(new Point(linhaAtual, colunaAtual));
        moverJogador(linhaAtual, colunaAtual);

        int[] deltaLinha = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] deltaColuna = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < deltaLinha.length; i++) {
            int novaLinha = linhaAtual + deltaLinha[i];
            int novaColuna = colunaAtual + deltaColuna[i];

            if (encontrarCaminho(novaLinha, novaColuna)) {
                return true;
            }
        }

        labirinto[linhaAtual][colunaAtual] = 1;
        caminho.pop();
        moverJogador(linhaAtual, colunaAtual);
        return false;
    }

    private void moverJogador(int novaLinha, int novaColuna) {

        SwingUtilities.invokeLater(() -> {
            cells[playerRow][playerCol].setBackground(Color.WHITE);
            playerRow = novaLinha;
            playerCol = novaColuna;
            cells[playerRow][playerCol].setBackground(Color.RED);
            repaint();
        });

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void exibirCaminhoFinal() {

        Stack<Point> caminhoInvertido = new Stack<>();
        while (!caminho.isEmpty()) {
            caminhoInvertido.push(caminho.pop());
        }

        while (!caminhoInvertido.isEmpty()) {

            Point p = caminhoInvertido.pop();
            SwingUtilities.invokeLater(() -> {
                cells[p.x][p.y].setBackground(Color.GREEN);
                repaint();
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[][] criarLabirinto() {

        String csvFile = "csvDemo.csv";
        return CSVReader.read(csvFile);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new Labirinto(criarLabirinto());
        });
    }
}
