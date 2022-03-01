import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Main {
    static int choice;
    public static void main(String[] args){
        //Φτιάχνω δύο Arraylist
        ArrayList<Apartment> Apartments = new ArrayList<Apartment>();
        ArrayList<Detached_house> Houses = new ArrayList<Detached_house>();

        while(true) {//Για να τρέχει συνέχεια
            printTheMenu();//καλώ το menu
            UserInput(Apartments,Houses);//Καλώ την συνάρτηση που επιλέγει ο χρήστης τι θέλει
        }
    }


    private static void printTheMenu() {//Εκτυπώνει
        System.out.println("__________________________________________________________________");
        System.out.println(" (it21824/e-mesitis/Thema 6)");
        System.out.println("(1) Εισαγωγή νέας κατοικίας!");
        System.out.println("(2) Εμφάνιση κατοικίας!");
        System.out.println("(3) Αποχωρήστε από το πρόγραμμα!");

    }
    private static void UserInput(ArrayList<Apartment> Apartments, ArrayList<Detached_house> houses)//Επιλέγει από το μενού και καλεί συναρτηση
    {
        System.out.printf("Πληκτρολογήστε(1-3):");
        Scanner input = new Scanner(System.in);
        choice=input.nextInt();
        switch (choice)//Για να ελέγξω την επιλογή του χρήστη
        {
            case 1:
                //καλώ την μέθοδο εισαγωγής νέας κατοικίας
                NewResidence(Apartments,houses);//Περνάω ως παραμέτρους τις δύο λίστες
                break;
            case 2:
                //καλώ την μέθοδο που μου επιστρέφει την κατοικία
                ViewResidence(Apartments,houses);//Περνάω ως παραμέτρους τις δύο λίστες
                break;
            case 3:
                System.exit(0); // Για να κλείσω το πρόγραμμα
                break;
            default://Σε περίπτωση λάθος επιλογής π.χ. 0 ή 4
                System.out.println("Λάθος επιλογή ξαναπροσπάθησε:(1-3)");
        }
    }
    private static void NewResidence(ArrayList<Apartment> Apartments,ArrayList<Detached_house> Houses)
    {
        Scanner input = new Scanner(System.in);// Για το input
        boolean isItApartment=false;
        boolean isItDetached_house=false;


        System.out.printf("Δήμος που ανοίκει το σπίτι:(Χωρίς κενά και έως 20 χαρακτήρες)");
        String δήμος=input.next();
        while(!OtherMethods.checkVariable(δήμος))// Έλεγχος λέξης και αν είναι κάτω από 20 χαρακτήρες(ΣΗΜΕΙΏΣΕΙΣ ΘΕΜΑ 6)
        {
            System.out.println(!OtherMethods.checkVariable(δήμος));
            System.out.printf("Λάθος Ξαναπροσπάθησε (εως 20 χαρακτήρες):");
            δήμος=input.next();
        }


        System.out.printf("Eμβαδό (τετραγωνικά μέτρα):");
        double area=input.nextDouble();
        while(area<=0)
        {
            System.out.printf("Λάθος Ξαναπροσπάθησε: ");
            area=input.nextDouble();
        }

        System.out.printf("Έτος κατασκευής: ");
        int year_of_construction=input.nextInt();
        while(year_of_construction<=1500)// Μια τυχαία τιμή
        {
            System.out.printf("Λάθος Ξαναπροσπάθησε(>1500): ");
            year_of_construction=input.nextInt();
        }

        System.out.printf("Πλήθος υπνοδωματίων: ");
        int bedrooms=input.nextInt();
        while(bedrooms<0)
        {
            System.out.printf("Λάθος Ξαναπροσπάθησε: ");
            bedrooms=input.nextInt();
        }

        System.out.printf("Πλήθος μπάνιων: ");
        int bathrooms=input.nextInt();
        while(bathrooms<=0)
        {
            System.out.printf("Λάθος Ξαναπροσπάθησε: ");
            bathrooms=input.nextInt();
        }

        System.out.printf("Τιμή ενοικίου: ");
        double rental_price=input.nextDouble();
        while(rental_price<=0)
        {
            System.out.printf("Λάθος Ξαναπροσπάθησε: ");
            rental_price=input.nextInt();
        }

        System.out.printf("Η κατοικία είναι :\n1)Διαμέρισμα \n2)Μονοκατοικία\nΑπάντηση(1,2):");
        int choice=input.nextInt();
        while(Boolean.FALSE.equals(OtherMethods.checkVariable(valueOf(choice),1,2)))//Έλεγχος μεταβλιτής όσο είναι λάθος το νούμερο
        {
            System.out.printf("Λάθος Ξαναπροσπάθησε: ");
            choice=input.nextInt();
        }
        String[] arr=new String[3];
        if (choice==1)
        {
             isItApartment=true;
             isItDetached_house=false;
             arr=Apartment.GetTheRest();
             int UniqueCode=Apartments.size()+Houses.size()+1;
             Apartments.add(new Apartment(δήμος,area,rental_price,year_of_construction,bedrooms,bathrooms,isItApartment,isItDetached_house,parseInt(arr[0]),arr[1],arr[2],UniqueCode));
             //Εμφάνιση μοναδικός κωδικός κατοικίας, ο δήμος, το εμβαδό της και το ενοίκιο.
            //size()-1 για να πάρω το τελευταίο index της λίστας
            System.out.println("_____________________________________________________________");
            System.out.println("Μοναδικός κωδικός: "+Apartments.get(Apartments.size()-1).getUniqueCode());
            System.out.println("Δήμος: "+Apartments.get(Apartments.size()-1).getΔήμος());
            System.out.println("Εμβαδόν: "+Apartments.get(Apartments.size()-1).getArea());
            System.out.println("Ενοίκιο: "+Apartments.get(Apartments.size()-1).getRental_price());
        }
        else
        {
             isItApartment=false;
             isItDetached_house=true;
             arr= Detached_house.GetTheRest();
            int UniqueCode=Apartments.size()+Houses.size()+1;
             Houses.add(new Detached_house(δήμος,area,rental_price,year_of_construction,bedrooms,bathrooms,isItApartment,isItDetached_house,parseInt(arr[0]),Double.parseDouble(arr[1]),arr[2],UniqueCode));
            //Εμφάνιση μοναδικός κωδικός κατοικίας, ο δήμος, το εμβαδό της και το ενοίκιο.
            //size()-1 για να πάρω το τελευταίο index της λίστας
            System.out.println("_____________________________________________________________");
            System.out.println("Μοναδικός κωδικός: "+Houses.get(Houses.size()-1).getUniqueCode());
            System.out.println("Δήμος: "+Houses.get(Houses.size()-1).getΔήμος());
            System.out.println("Εμβαδόν: "+Houses.get(Houses.size()-1).getArea());
            System.out.println("Ενοίκιο: "+Houses.get(Houses.size()-1).getRental_price());
        }
        System.out.println("__________________________________________________________________");

    }

    private static void ViewResidence(ArrayList<Apartment> Apartments,ArrayList<Detached_house> Houses)
    {
        System.out.println("__________________________________________________________________");
        Scanner input = new Scanner(System.in);

        boolean found=false;
        String House_is;

        System.out.printf("Μοναδικός κωδικός κατοικίας που επιθυμείτε να δείτε:");
        int Code=input.nextInt();
        for(Apartment Ap : Apartments) //Περνάω από την αρχή όλο το ArrayList
        {
           if (Ap.getUniqueCode()==Code)
           {
               //ο κωδικός κατοικίας, αν είναι διαμέρισμα ή μονοκατοικία και το ενοίκιο.
                System.out.println("Μοναδικός κωδικός κατοικίας : "+Ap.getUniqueCode());
                if (Ap.isItApartment())
                {
                     House_is="Διαμέρισμα";
                }
                else
                    {
                        House_is="Μονοκατοικία";
                    }
                System.out.println("Η κατοικία είναι : "+House_is);
                System.out.println("Το ενοίκιο είναι : "+ Ap.getRental_price());
                found=true;
                return;
           }
        }
        for(Detached_house De : Houses) //Περνάω από την αρχή όλο το ArrayList
        {
            if (De.getUniqueCode()==Code)
            {
                //ο κωδικός κατοικίας, αν είναι διαμέρισμα ή μονοκατοικία και το ενοίκιο.
                System.out.println("Μοναδικός κωδικός κατοικίας : "+De.getUniqueCode());
                if (De.isItApartment())
                {
                    House_is="Διαμέρισμα";
                }
                else
                {
                    House_is="Μονοκατοικία";
                }
                System.out.println("Η κατοικία είναι : "+House_is);
                System.out.println("Το Ενοίκιο είναι : "+ De.getRental_price());
                found=true;
                return;
            }
        }
        if (!found)
        {
            System.out.println("Ο μοναδικός κωδικός δεν αντιστοιχεί σε κάποια κατοικία!");
        }
    }
}
