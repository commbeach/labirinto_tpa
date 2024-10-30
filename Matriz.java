import java.util.ArrayList;

public class Matriz {

    public ArrayList<ArrayList<String>> matriz;

    public void print() {

        for (int i = 0; i < this.matriz.size(); i++) {
            System.out.println(this.matriz.get(i));
        }
        System.out.println();

    }

    public String getElem(int linha, int coluna) {
        ArrayList<String> l = this.matriz.get(linha);
        return l.get(coluna);
    }

    public void setElem(int linha, int coluna, String valor) {
        this.matriz.get(linha).set(coluna, valor);
    }

    public boolean isValid(int linha, int coluna) {
        if (linha < 0 || coluna < 0 || linha >= matriz.size() || coluna >= matriz.get(0).size()) {
            return false;
        }
        return getElem(linha, coluna).equals("1");
    }

    private void pause() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean encontrarCaminho(int linhaAtual, int colunaAtual, int linhaSaida, int colunaSaida, ArrayList<Integer> caminho_linha, ArrayList<Integer> caminho_coluna) {
        // Método não utilizado na versão atual
        return false;
    }
}
