import java.io.*;  
/**
 * Write a description of class Basketball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Basketball
{
  public static void main(String args[]){
   try {
    BufferedReader in = new BufferedReader(new FileReader("members.txt"));
    String line;
    Bill x;
    PrintWriter outanalysis =new PrintWriter( new FileWriter("analysis2018.txt"));
    x = new Bill();
    x.value =0;x.females=0;x.males=0;x.fund=0;
    outanalysis.print("2018 CLUB MEMBERS INFORMATION\n");
    outanalysis.print("List names of members who do not pay the full amount of monthly fees\n");
    System.out.println("POTENTIAL NEW COMMITTEE MEMBERS");
    System.out.printf("%-30s %-15s %-15s %n","NAME","IC","POSITION PLAYED");
    while((line=in.readLine())!=null){
    checkpayment(line, outanalysis, x);
    countgender(line, x);
    countfund(line, x);
    findmembercommit(line, x);
    }
    outanalysis.print("\n\n1.Number of males members:"+x.males+"\n");
    outanalysis.print("2.Number of females members:"+x.females+"\n");
    outanalysis.print("3.Total number of club members:"+x.females+x.females+"\n");
    outanalysis.print("4.Total club fund (2018):RM"+x.fund);
    in.close();
    outanalysis.close();
   } catch (Exception e) {
   System.out.println("error");
   }
  }
  public static void checkpayment(String line,PrintWriter out,Bill x) {
 
  String[] array = line.split(";",7);
  if(!array[6].equals("120.00")){
    x.value=x.value+1;
  out.printf("%-30s %-12s %-15s %n",x.value+"."+array[0],array[1],array[6]);
  }
}
  public static void countgender(String line,Bill x){
    String[] array = line.split(";",7);
    if(array[2].equalsIgnoreCase("male")){
      x.males=x.males+1;
    }else{
      x.females=x.females+1;
    }
  }

  public static void countfund(String line,Bill x){
    String[] array = line.split(";",7);
    double d = Double.parseDouble(array[6]);
    x.fund=x.fund+d;
  }
  public static void findmembercommit(String line,Bill x){
    String[] array = line.split(";",7);
   int  training = Integer.parseInt(array[3]);
   int game = Integer.parseInt(array[5]);
   double fee = Double.parseDouble(array[6]);
    if(training>=15 && game>=2 && fee>=90.00){
      x.bill=x.bill+1;
    System.out.printf("%-30s %-15s %-15s %n",array[0],array[1],array[4]);
    }
  }
 
}
