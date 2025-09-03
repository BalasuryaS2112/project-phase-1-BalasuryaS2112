import java.io.*;
import java.util.Scanner;
public class Merchant {
    String merchantID;
    String merchantName;
    String merchantPhone;
    String merchantAddress;
    public Merchant(){
        
    }
    public Merchant(String merchantID, String merchantName, String merchantPhone, String merchantAddress) {
        this.merchantID = merchantID;
        this.merchantName = merchantName;
        this.merchantPhone = merchantPhone;
        this.merchantAddress = merchantAddress;
    }
    public String getMerchantID() {
        return merchantID;
    }
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }
    public String getMerchantName() {
        return merchantName;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    public String getMerchantPhone() {
        return merchantPhone;
    }
    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }
    public String getMerchantAddress() {
        return merchantAddress;
    }
    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }
    @Override
    public String toString() {
        return "Merchant ID=" + merchantID + "\nMerchant Name=" + merchantName + "\nMerchant Phone="
                + merchantPhone + "\nMerchant Address=" + merchantAddress + "\n----------------";
    }
    public void writeToFile(){
        try{
            FileWriter fw=new FileWriter("Merchant.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println(toString());
            pw.close();
            bw.close();
            fw.close();
            System.out.println("Merchant added successfully!");
        }
        catch(Exception e){
            System.out.println("An error occured:"+e.getMessage());
        }
    }
    public void viewFromFile(){
        File file=new File("Merchant.txt");
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
        File file=new File("Merchant.txt");
        try{
            Scanner sc=new Scanner(file);
            int count=0;
            while(sc.hasNextLine()){
                String str=sc.nextLine();
                if(str.equals("Merchant ID="+id)){
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
