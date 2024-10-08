import java.io. * ;
import java.util.ArrayList; 

public class CSVReader {

  public static final String delimiter = ",";
  public static int[][] read(String csvFile) {
    Matriz m = new Matriz();
    m.matriz = new ArrayList<ArrayList<String>>();
    int tam_linha=0;
    int tam_coluna=0;

    try {
      File file = new File(csvFile);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = " ";
      String[] tempArr;
      while ((line = br.readLine()) != null) {
        tam_linha++;
        tam_coluna=0;
        tempArr = line.split(delimiter);
        ArrayList<String> linha = new ArrayList<String>();
        for (String tempStr: tempArr) {
          tam_coluna++;
          linha.add(tempStr);
          //System.out.print(tempStr + " ");
        }
        m.matriz.add(linha);
        //System.out.println();
      }
      br.close();
    }
    catch(IOException ioe) {
      ioe.printStackTrace();
    }
    m.print();
    System.out.println("tamanho: "+tam_linha+tam_coluna);
    int[][] lab = new int[tam_linha][tam_coluna];
    for(int l=0;l<tam_linha;l++){
      System.out.println(lab);
      
      for(int c=0;c<tam_coluna;c++){
        lab[l][c]=Integer.parseInt(m.getElem(l,c));
      }
    }
    return lab;
  }


 

}
