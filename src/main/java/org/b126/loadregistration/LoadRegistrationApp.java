package org.b126.loadregistration;
import java.util.Scanner;

public class LoadRegistrationApp {
    static Scanner sc = new Scanner(System.in);
    static short LoadBalance = (short) (Math.random() * 101 + 50);
    static String option = "";

    public static void run(){
        clearTerminal();

        System.out.println("Dial *143# to access TM Services: ");
        System.out.print("Enter USSD: ");
        String userInput = sc.nextLine();
        if(!userInput.equals("*143#")){
            return;
        }
        showMainMenu();
    }

    public static void showMainMenu(){
        Promo[] pawerSurf = {
                new Promo("1", "PawerSURF20", "1GB data and 250 mins call & 250 Text for 1 day. P20", 20),
                new Promo("2","PawerSURF30","2GB data for 2 days. P30",  30),
                new Promo("3","PawerSURF99","3GB data 6GB FunAliw apps and unli call &  Text for 7 days. P99",99),
                new Promo("4", "Back", "", 0),
        };

        Promo[] unliCallsAndTexts = {
                new Promo("1", "CA20", "Unli All-Net calls & texts for 3 days. P20", 20),
                new Promo("2", "C30", "Unli TM/Globe calls & texts for 5 days. P30", 30),
                new Promo("3", "UAN50", "Unli All-Net calls & texts for 7 days. P50", 50),
                new Promo("4", "Back", "", 0)
        };

        Promo[] easySurf = {
                new Promo("1", "EasySURF50", "9GB + Unli AllNET Text for 3 days. 50", 50),
                new Promo("2","EasySURF75","2GB Data + 6GB Apps + Unli AllNET calls Text for 3 days. 75",  75),
                new Promo("3","EasySURF99","3GB Data, 14GB apps + Unli Allnet Texts,P99/7 days",99),
                new Promo("4", "Back", "", 0),
        };

        Promo[] allSurf = {
                new Promo("1", "ALLSURF99", "7GB Data for all sites", 99),
                new Promo("2","ALLSURF110","8GB Data + 7GB FunAliw Apps",  110),
                new Promo("3","ALLSURF149","12GB data + UNLI 5G + 7GB FunAliw Apps",149),
                new Promo("4", "Back", "", 0),
        };

        Promo[] easyPlan = {
                new Promo("1", "EasyPLAN 150", "Unli allnet calls & Text + 2GB Data + 30GB, 150/30 days", 150),
                new Promo("2","EasyPLAN 200","Unli allnet calls & Text + 2GB Data + 45GB, 200/30 days",  200),
                new Promo("3","EasyPLAN 300","Unli allnet calls & Text + 2GB Data + 60GB, 300/30 days",300),
                new Promo("4", "Back", "", 0),
        };

        while(true) {
            System.out.println("\nRegular Load: ₱" + LoadBalance);

            String[] listOfPromo = {"[1] Unli Call & Text", "[2] PawerSURF", "[3] EASYSURF", "[4] ALLSURF", "[5] EasyPLAN", "[6] Exit"};

            for (String promo : listOfPromo) {
                System.out.println(promo);
            }

            System.out.print("Select Option: ");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    showSubMenu(unliCallsAndTexts);
                    break;
                case "2":
                    showSubMenu(pawerSurf);
                    break;
                case "3":
                    showSubMenu(easySurf);
                    break;
                case "4":
                    showSubMenu(allSurf);
                    break;
                case "5":
                    showSubMenu(easyPlan);
                    break;
                case "6":
                    showExitMenu();
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }
    }
    public static void showSubMenu(Promo[] subPromos){
        while(true){
            for(Promo selection: subPromos){
                System.out.println("["+selection.id+"] " + selection.promoName );
            }

            System.out.print("Select Option: ");
            option = sc.nextLine();

            switch (option){
                case "1":
                    performRegistration(subPromos[0]);
                    break;
                case "2":
                    performRegistration(subPromos[1]);
                    break;
                case "3":
                    performRegistration(subPromos[2]);
                    break;
                case"4":
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
    public static  void performRegistration(Promo promo) {
        String message = "";
        System.out.println("*** " + promo.promoName + " ***");
        System.out.println("*** " + promo.promoDescription + " ***");
        System.out.println("Regular Load: ₱" + LoadBalance);
        String[] surfPromo = {"[1] Subscribe", "[2] Back", "[3] Exit"};

        while (true) {

            for (String selection : surfPromo) {
                System.out.println(selection);
            }

            System.out.print("Select Option: ");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    if(LoadBalance >= promo.promoPrice ) {
                        LoadBalance -= (short) promo.promoPrice;
                        message = String.format("You are now subscribed to %s  %nAvailable Balance: %d", promo.promoName, LoadBalance );
                    }
                    else{
                        message = "Not Enough Load Balance Please Top up Load: ";
                    }
                    break;
                case "2":
                    return;
                case "3":
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

            System.out.println(message);

            if(option.equals("1") || option.equals("3")){
                sc.close();
                System.exit(0);
            }
        }
    }
    public static void showExitMenu(){
        System.out.print("Proceed to Exit? y/n:");
        char selection = sc.nextLine().trim().charAt(0);

        if(Character.toLowerCase(selection) == 'y'){
            sc.close();
            System.exit(0);
        }

    }
    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class Promo {
    String id;
    String promoName;
    String promoDescription;
    int promoPrice;

    public Promo(String id, String promoName, String promoDescription, int promoPrice){
        this.id =id;
        this.promoName = promoName;
        this.promoDescription = promoDescription;
        this.promoPrice =  promoPrice;
    }
}