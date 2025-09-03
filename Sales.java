
import java.io.*;
import java.util.Scanner;
public class Sales {
    String salesID;
    String merchantID;
    String farmerID;
    String product;
    Double quantity;
    Double price;
    public Sales(){
        
    }
    public Sales(String salesID, String merchantID, String farmerID, String product, Double quantity, Double price) {
        this.salesID = salesID;
        this.merchantID = merchantID;
        this.farmerID = farmerID;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    public String getSalesID() {
        return salesID;
    }
    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }
    public String getMerchantID() {
        return merchantID;
    }
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }
    public String getFarmerID() {
        return farmerID;
    }
    public void setFarmerID(String farmerID) {
        this.farmerID = farmerID;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Sales ID=" + salesID + "\nMerchant ID=" + merchantID + "\nFarmer ID=" + farmerID + "\nProduct="
                + product + "\nQuantity=" + quantity+" kg\nPrice=" + price + " rupees\n----------------";
    }
    public void writeToFile(){
        try{
            FileWriter fw=new FileWriter("Sales.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println(toString());
            pw.close();
            bw.close();
            fw.close();
            System.out.println("Sales added successfully!");
        }
        catch(Exception e){
            System.out.println("An error occured:"+e.getMessage());
        }
    }
    public void viewFromFile(){
        File file=new File("Sales.txt");
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
        File file=new File("Sales.txt");
        try{
            Scanner sc=new Scanner(file);
            int count=0;
            while(sc.hasNextLine()){
                String str=sc.nextLine();
                if(str.equals("Sales ID=" + id)){
                    while(count<7){
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
