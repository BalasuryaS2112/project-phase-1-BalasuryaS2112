import java.io.*;
import java.util.Scanner;
public class Farmer{
    String farmerID;
    String farmerName;
    String farmerPhone;
    String farmerAddress;
    public Farmer() {
    }
    public Farmer(String farmerID, String farmerName, String farmerPhone, String farmerAddress) {
        this.farmerID = farmerID;
        this.farmerName = farmerName;
        this.farmerPhone = farmerPhone;
        this.farmerAddress = farmerAddress;
    }
    public String getFarmerID() {
        return farmerID;
    }
    public void setFarmerID(String farmerID) {
        this.farmerID = farmerID;
    }
    public String getFarmerName() {
        return farmerName;
    }
    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }
    public String getFarmerPhone() {
        return farmerPhone;
    }
    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }
    public String getFarmerAddress() {
        return farmerAddress;
    }
    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }
    @Override
    public String toString() {
        return "Farmer ID=" + farmerID + "\nFarmer Name=" + farmerName + "\nFarmer Phone=" + farmerPhone
                + "\nFarmer Address=" + farmerAddress + "\n----------------";
    }
    public void writeToFile(){
        try{
            FileWriter fw=new FileWriter("Farmer.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println(toString());
            pw.close();
            bw.close();
            fw.close();
            System.out.println("Farmer added successfully!");
        }
        catch(Exception e){
            System.out.println("An error occured:"+e.getMessage());
        }
    }
    public void viewFromFile(){
        File file=new File("Farmer.txt");
        try{
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String str=sc.nextLine();
                System.out.println(str);
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("An error occured while reading the file:"+e.getMessage());
        }
    }
    public void viewByID(String id){
        File file=new File("Farmer.txt");
        try{
            Scanner sc=new Scanner(file);
            int count=0;
            while(sc.hasNextLine()){
                String str=sc.nextLine();
                if(str.equals("Farmer ID="+id)){
                    while(count<5){
                        System.out.println(str);
                        str=sc.nextLine();
                        count++;
                    }
                    break;
                }
            }
            if(count==0)
            System.out.println("Record not found");
            sc.close();
        }
        catch(Exception e){
            System.out.println("An error occured while reading the file:"+e.getMessage());
        }
    }
}