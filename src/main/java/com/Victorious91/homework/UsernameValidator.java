import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {

        // Folosesc un obiect scanner pentru a citi de la tastatura:
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;

        do {
            System.out.println("Introdu un username:");
            String user = scanner.nextLine();
            //Am zis sa fiu mai creativ si am decis sa compar lungimile username-ului initial cu cel dupa ce am scos spatiile si daca length-ul difera atunci inseamna ca are spatii ;) :
            int LungimeInitiala = user.length();
            String faraSpatii = user.replace(" ","");
            int lungimeFaraSpatii = faraSpatii.length();

            if (LungimeInitiala != lungimeFaraSpatii) {
                System.out.println("Introdu user fara spatii te rog");

                // Aici e ramura pe care am verificat lungimea ca este adecvata:
            } else if (user.length() < 6 || user.length() > 12) {
                System.out.println("Username-ul trebuie sa aiba intre 6 si 12 caractere");

                // Aici e ramura in care am verificat daca am introdus si o cifra, am folosit flag-ul hasDigit si am parcurs username-ul element cu element:
            } else {
                boolean hasDigit = false;
                for (int i = 0; i < user.length(); i++) {
                    if (Character.isDigit(user.charAt(i))) {
                        hasDigit = true;
                        break;
                    }
                }

                if (hasDigit) {
                    isValid = true;
                    System.out.println("Username acceptat: "+user);
                } else {
                    System.out.println("Minim un caracter sa fie numar");
                }
            }
        } while (!isValid);
    }
}