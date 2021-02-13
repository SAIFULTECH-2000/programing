import java.io.*;  

/**
 * @author SAIFULTECH/SYAMIEL
 * 
 */


public class FoodFestival {
    public static void main(String args[]){
       try {
           BufferedReader in = new BufferedReader(new FileReader("food.txt"));
           PrintWriter outWestern =new PrintWriter( new FileWriter("Western.txt"));
           PrintWriter outMalay = new PrintWriter(new FileWriter("Malay.txt"));
           PrintWriter outchinesse =new PrintWriter( new FileWriter("chinesse.txt"));
            
           outWestern.write("**************Western Food****************"+"\n");
           outMalay.write("**************Malay Food****************"+"\n");
           outchinesse.write("**************Chinesse Food****************"+"\n");
           outWestern.printf("%-15s %-15s %-15s %n", "Name of food"," Price", "Chef");
           outMalay.printf("%-15s %-15s %-15s %n", "Name of food"," Price", "Chef");
           outchinesse.printf("%-15s %-15s %-15s %n", "Name of food"," Price", "Chef");
           String line;
           int Zack=0;
           while((line=in.readLine())!=null){
            String[] array = line.split(";",4);
            double d = Double.parseDouble(array[2]);
            if(d>20)
            System.out.println(array[0]+"\t"+array[2]);
            if(array[3].equals("Zack"))
            Zack=Zack+1;
            if(array[1].equals("Western")){
            WriteMenu(line, outWestern);
            }else if(array[1].equals("Malay")){
            WriteMenu(line, outMalay);
            }else{
            WriteMenu(line, outchinesse);
            }   
           }
           in.close();
           outWestern.close();
           outMalay.close();
           outchinesse.close();
           System.out.println("Number food cook by Zack are "+Zack);
       } catch (Exception e) {
        System.out.println("Something went wrong.");
       }
      
    }
    public static void WriteMenu(String line,PrintWriter out){
    String[] array = line.split(";",4);
    out.printf("%-15s %-15s %-15s %n", array[0],array[2],array[3]);
    }
}
