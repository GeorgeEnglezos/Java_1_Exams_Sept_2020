import java.util.Scanner;

public class OtherMethods {
    public static boolean checkVariable(String value, int min, int max){//Έλεγχος για το νούμερο
        boolean correct=true;
        if (value.matches("[0-9]+")){
            if(Integer.parseInt(value)<min || Integer.parseInt(value)>max) {
                correct = false;
            }
        } else{
            correct=false;
        }
        return correct; //Επιστρέφω αν είναι σωστό το νούμερο
    }

    public static boolean checkVariable(String word ){// if the names contain only letters
        boolean correct=true;

        if (!((word != null) && (!word.equals("")) && ((word.matches("^[a-zA-Z]*$"))) && word.length( )<20))
        {
            correct=false;
        }
        return correct;//Επιστρέφω αν είναι σωστή η λέξη
    }

    public static String check_yes_or_no(String answer)
    {
        Scanner input = new Scanner(System.in);
        while(true) //Όσο είναι λάθος
        {
            if (answer.equals("Ναι")||answer.equals("ναι")||answer.equals("Όχι")||answer.equals("όχι")||answer.equals("οχι")||answer.equals("Οχι"))
            {
                return answer;
            }
            else
                {
                    System.out.printf("Λάθος απάντηση , αποδεκτές απαντήσεις είναι Ναι ή Όχι");
                    answer=input.nextLine();
                }
        }
    }


}
