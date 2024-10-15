import java.io.*;
import java.util.ArrayList;

public class CSVReader {

  public static final String delimiter = ",";
  public static int[][] read(String csvFile) {

    int tam_linha = 0;
    int tam_coluna = 0;

    try {
      File file = new File(csvFile);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      String[] tempArr;
      while ((line = br.readLine()) != null) {
        tam_linha++;
        tempArr = line.split(delimiter);
        if (tam_linha == 1) {
          tam_coluna = tempArr.length;
        } else {
          if (tempArr.length != tam_coluna) {
            System.err.println("Erro: Inconsistência no número de colunas na linha " + tam_linha);
            br.close();
            return new int[0][0];
          }
        }
        ArrayList<String> linha = new ArrayList<String>();
        for (String tempStr : tempArr) {
          linha.add(tempStr.trim());
        }
        m.matriz.add(linha);
      }
      br.close();
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
    m.print();
    System.out.println("Tamanho: " + tam_linha + "x" + tam_coluna);
    int[][] lab = new int[tam_linha][tam_coluna];
    for(int l = 0; l < tam_linha; l++) {
      for(int c = 0; c < tam_coluna; c++) {
        try {
          lab[l][c] = Integer.parseInt(m.getElem(l, c));
        } catch (NumberFormatException e) {
          System.err.println("Erro: Valor não numérico na posição (" + l + "," + c + ")");
          lab[l][c] = 0;
        }
      }
    }
    return lab;
  }
}
