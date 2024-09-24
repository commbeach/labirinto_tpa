import java.util.ArrayList; 

public class Matriz {
   public ArrayList<ArrayList<String>> matriz;

   public void print(){
        for(int i=0;i<this.matriz.size();i++){
            System.out.println(this.matriz.get(i));
        }
   }

   public String getelem(int linha,int coluna){
    ArrayList<String> l = this.matriz.get(linha);
    String elem = l.get(coluna);
    return elem;
   }

   
}
