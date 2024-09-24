import java.io. * ;
import java.util.ArrayList; 

public class CSVReader {

  public static final String delimiter = ",";
  public static Matriz read(String csvFile) {
    Matriz m = new Matriz();
    m.matriz = new ArrayList<ArrayList<String>>();

    try {
      File file = new File(csvFile);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = " ";
      String[] tempArr;
      while ((line = br.readLine()) != null) {
        tempArr = line.split(delimiter);
        ArrayList<String> linha = new ArrayList<String>();
        for (String tempStr: tempArr) {
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
    return m;
  }


 

}
