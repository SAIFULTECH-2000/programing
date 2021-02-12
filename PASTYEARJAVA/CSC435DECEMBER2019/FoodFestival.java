import java.io.*;  

/**
 * @author SAIFULTECH
 * 
 */


public class FoodFestival {
    public static void main(String args[]){
       try {
           BufferedReader in = new BufferedReader(new FileReader("food.txt"));
           FileWriter outWestern = new FileWriter("Western.txt");
           FileWriter outMalay = new FileWriter("Malay.txt");
           FileWriter outchinesse = new FileWriter("chinesse.txt");
            
           outWestern.write("**************Western Food****************"+"\n");
           outMalay.write("**************Malay Food****************"+"\n");
           outchinesse.write("**************Chinesse Food****************"+"\n");
           outWestern.write("Name of food\tPrice\tChef"+"\n");
           outMalay.write("%-15s %-15s %-15s %n" "Name of food, Price, Chef");
           outchinesse.write("Name of food\tPrice\tChef"+"\n");
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
            outWestern.write(WriteMenu(line)+"\n");
            }else if(array[1].equals("Malay")){
            outMalay.write("%-15s %-15s %-15s %n" WriteMenu(line));
            }else{
            outchinesse.write(WriteMenu(line)+"\n");
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
    public static String WriteMenu(String line){
    String[] array = line.split(";",4);
    return array[0]+"\t"+array[2]+"\t"+array[3];
    }
}
