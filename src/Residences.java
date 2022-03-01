import java.util.Scanner;

import static java.lang.String.valueOf;

public class Residences {
    //Μεταβλητές
    String δήμος;
    double area; //εμβαδό(τετραγωνικά μέτρα)
    double rental_price; //τιμή_ενοικίου
    int  year_of_construction;//έτος κατασκευής
    int bedrooms; //υπνοδωματια
    int bathrooms; //πλήθος_μπάνιων
    boolean isItApartment;
    boolean isItDetached_house;
    int UniqueCode;
    //Getters και Setters
    public String getΔήμος() {
        return δήμος;
    }

    public void setΔήμος(String δήμος) {
        this.δήμος = δήμος;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRental_price() {
        return rental_price;
    }

    public void setRental_price(double rental_price) {
        this.rental_price = rental_price;
    }

    public int getYear_of_construction() {
        return year_of_construction;
    }

    public void setYear_of_construction(int year_of_construction) {
        this.year_of_construction = year_of_construction;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isItApartment() {
        return isItApartment;
    }

    public void setItApartment(boolean itApartment) {
        isItApartment = itApartment;
    }

    public boolean isItDetached_house() {
        return isItDetached_house;
    }

    public void setItDetached_house(boolean itDetached_house) {
        isItDetached_house = itDetached_house;
    }
    public int getUniqueCode()
    {
        return  UniqueCode;
    }
}
//Subclass 1
class Apartment extends Residences {                                                                                                                    //ο όροφος
    int floor;//ο όροφος
    String parking;//αν έχει θέση στάθμευσης
    String storehouse;//αν έχει αποθήκη
    //Constructor
    public Apartment(String δήμος, double area, double rental_price, int year_of_construction, int bedrooms, int bathrooms, boolean isItApartment, boolean isItDetached_house,int floor,String parking,String storehouse,int UniqueCode) {
        this.δήμος=δήμος;
        this.area=area;
        this.rental_price=rental_price;
        this.year_of_construction=year_of_construction;
        this.bedrooms=bedrooms;
        this.bathrooms=bathrooms;
        this.floor=floor;//ο όροφος
        this.parking=parking;//αν έχει θέση στάθμευσης
        this.storehouse=storehouse;//αν έχει αποθήκη
        this.UniqueCode=UniqueCode;
        this.isItApartment=isItApartment;
        this.isItDetached_house=isItDetached_house;
    }

    public static String[] GetTheRest() {//Θέλω να επιστρέψει Array[]
        Scanner input = new Scanner(System.in);
        //Μεταβλητές
        String[] arr=new String[3];
        int floor;//ο όροφος
        String parking;//αν έχει θέση στάθμευσης
        String storehouse;//αν έχει αποθήκη

        //Εκχωρήσεις
        System.out.printf("Σε ποιον όροφο είναι:");
        floor = input.nextInt();
        while(floor<-1)// έλεγχος , το -1 και καλά ημιυπόγειο
        {
            System.out.printf("Λάθος Ξαναπροσπαθήσε:");
            floor = input.nextInt();
        }

        System.out.printf("Έχει θέση σταύθμευσης:(Ναι/Όχι)");
        parking = input.next();
        parking=OtherMethods.check_yes_or_no(parking);//έλεγχος

        System.out.printf("Έχει αποθήκη:(Ναι/Όχι)");
        storehouse = input.next();
        storehouse= OtherMethods.check_yes_or_no(storehouse);//έλεγχος

        arr[0]=valueOf(floor);
        arr[1]=parking;
        arr[2]=storehouse;
        return arr;
    }


}
//Subclass 2
class Detached_house extends Residences {
    int floors;//πλήθος των ορόφων
    double area_of_plot;//εμβαδό του οικοπέδου
    String fireplace;//αν έχει τζάκι
    //Constructor
    public Detached_house(String δήμος, double area, double rental_price, int year_of_construction, int bedrooms, int bathrooms, boolean isItApartment, boolean isItDetached_house,int floors,double area_of_plot,String fireplace,int UniqueCode) {
        this.δήμος=δήμος;
        this.area=area;
        this.rental_price=rental_price;
        this.year_of_construction=year_of_construction;
        this.bedrooms=bedrooms;
        this.bathrooms=bathrooms;
        this.floors=floors;//πλήθος των ορόφων
        this.area_of_plot=area_of_plot;//εμβαδό του οικοπέδου
        this.fireplace=fireplace;//αν έχει τζάκι
        this.isItApartment=isItApartment;
        this.isItDetached_house=isItDetached_house;
        this.UniqueCode=UniqueCode;
    }


    public static String[] GetTheRest() {//Θέλω να επιστρέψει Array[]
        Scanner input = new Scanner(System.in);

        //Παράμετροι
        int floors;//πλήθος των ορόφων
        double area_of_plot;//εμβαδό του οικοπέδου
        String fireplace;//αν έχει τζάκι
        String[] arr=new String[3];


        System.out.printf("Πλήθος των ορόφων:");
        floors = input.nextInt();
        while(floors<0)//
        {
            System.out.printf("Λάθος Ξαναπροσπαθήσε:");
            floors = input.nextInt();
        }

        System.out.printf("Eμβαδό του οικοπέδου:");
        area_of_plot = input.nextDouble();
        while(area_of_plot<=0)// Ημιυπόγειο
        {
            System.out.printf("Λάθος Ξαναπροσπαθήσε:");
            area_of_plot = input.nextInt();
        }

        System.out.printf("Έχει τζάκι:(Ναι/Όχι)");
        fireplace = input.next();
        fireplace= OtherMethods.check_yes_or_no(fireplace);//έλεγχος


        arr[0]=valueOf(floors);
        arr[1]=valueOf(area_of_plot);
        arr[2]=fireplace;
        return arr;
    }
}

