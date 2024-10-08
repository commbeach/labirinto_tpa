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
            Thread.sleep(500);  // 0.5 segundo de pausa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean encontrarCaminho(int linhaAtual, int colunaAtual, int linhaSaida, int colunaSaida, ArrayList<Integer> caminho_linha, ArrayList<Integer> caminho_coluna) {

        System.out.println(caminho_linha);
        System.out.println(caminho_coluna);
        System.out.println(linhaAtual);
        System.out.println(colunaAtual);

        for(int i=0;i<caminho_coluna.size();i++){
            if(caminho_linha.get(i)==linhaAtual && caminho_coluna.get(i)==colunaAtual){
                System.out.println(colunaAtual+linhaAtual);
                setElem(caminho_linha.get(i-1),caminho_coluna.get(i-1),"1");
                break;
            }
        }


        if (linhaAtual == linhaSaida && colunaAtual == colunaSaida) {
            setElem(linhaAtual, colunaAtual, "X");
            print();
            return true;
        }


        if (!isValid(linhaAtual, colunaAtual)) {
            return false;
        }


        setElem(linhaAtual, colunaAtual, "X");
        caminho_linha.add(linhaAtual);
        caminho_coluna.add(colunaAtual);
        print();
        pause();


        int[] deltaLinha = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] deltaColuna = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int novaLinha = linhaAtual + deltaLinha[i];
            int novaColuna = colunaAtual + deltaColuna[i];


            if (encontrarCaminho(novaLinha, novaColuna, linhaSaida, colunaSaida, caminho_linha, caminho_coluna)) {
                return true;
            }
        }


        setElem(linhaAtual, colunaAtual, "1");
        print();
        pause();

        return false;
    }
}
