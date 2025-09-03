import java.util.*;
public class Main {
    public static void addFarmer(Scanner sc){
        String a,b,c,d;
        System.out.print("Enter farmer ID:");
        a=sc.nextLine();
        System.out.print("Enter farmer name:");
        b=sc.nextLine();
        System.out.print("Enter farmer mobile number:");
        c=sc.nextLine();
        System.out.print("Enter farmer address:");
        d=sc.nextLine();
        Farmer f=new Farmer(a,b,c,d);
        f.writeToFile();
    }
    public static void addMerchant(Scanner sc){
        String a,b,c,d;
        System.out.print("Enter merchant ID:");
        a=sc.nextLine();
        System.out.print("Enter merchant name:");
        b=sc.nextLine();
        System.out.print("Enter merchant mobile number:");
        c=sc.nextLine();
        System.out.print("Enter merchant address:");
        d=sc.nextLine();
        Merchant m=new Merchant(a,b,c,d);
        m.writeToFile();
    }
    public static void addSales(Scanner sc){
        String a,b,c,d;
        Double e,f;
        System.out.print("Enter sales ID:");
        a=sc.nextLine();
        System.out.print("Enter merchant ID:");
        b=sc.nextLine();
        System.out.print("Enter farmer ID:");
        c=sc.nextLine();
        System.out.print("Enter product name:");
        d=sc.nextLine();
        System.out.print("Enter quantity in kg:");
        e=sc.nextDouble();
        System.out.print("Enter price in rupees:");
        f=sc.nextDouble();
        Sales s=new Sales(a,b,c,d,e,f);
        s.writeToFile();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String id;
        int choice;
        do{
            System.out.print("1)Add farmer\n2)Add Merchant\n3)Add Sales\n4)View all farmers\n5)View all merchant\n");
            System.out.print("6)View all sales\n7)View farmers by ID\n8)View merchants by ID\n9)View sales by ID\n10)Exit\nEnter your choice:");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                   addFarmer(sc);
                   break;
                case 2:
                   addMerchant(sc);
                   break;
                case 3:
                   addSales(sc);
                   break;
                case 4:
                   Farmer f=new Farmer();
                   f.viewFromFile();
                   break;
                case 5:
                   Merchant m=new Merchant();
                   m.viewFromFile();
                   break;
                case 6:
                   Sales s=new Sales();
                   s.viewFromFile();
                   break;
                case 7:
                   System.out.print("Enter the ID:");
                   id=sc.nextLine();
                   Farmer farmer=new Farmer();
                   farmer.viewByID(id);
                   break;
                case 8:
                   System.out.print("Enter the ID:");
                   id=sc.nextLine();
                   Merchant merchant=new Merchant();
                   merchant.viewByID(id);
                   break;
                case 9:
                   System.out.print("Enter the ID:");
                   id=sc.nextLine();
                   Sales sales=new Sales();
                   sales.viewByID(id);
                   break;
                case 10:
                   System.out.println("Thank you for using the system");
                   break;
                default:
                   System.out.println("Invalid choice");
            }
        }
        while(choice!=10);
        sc.close();
    }

}
