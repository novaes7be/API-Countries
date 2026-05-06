import java.util.Scanner;

public class MenuService {

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        //switch
        ClientHttp clientHttp = new ClientHttp();
        boolean exit = false;

    do {

        System.out.println("\n");
        System.out.println("1 - Show all countries names");
        System.out.println("2 - List countries by REGION");
        System.out.println("3 - List countries by LANGUAGE");
        System.out.println("4 - Get all countries name and currencies");
        System.out.println("0 - EXIT \n");

        System.out.print("Digit one of this numbers: " );
        int menuChoose = scanner.nextInt();
        scanner.nextLine();


            switch (menuChoose) {
                case 1:
                    String jsonName = clientHttp.getByName();
                    CountryParser.parseName(jsonName);
                    break;
                case 2:
                    System.out.print("Digit a region: ");
                    String region = scanner.nextLine();
                    String jsonRegion = clientHttp.getByRegion(region);
                    CountryParser.parseRegion(jsonRegion);
                    break;
                case 3:
                    System.out.print("Digit a language: ");
                    String language = scanner.nextLine();
                    String jsonLang = clientHttp.getByLanguage(language);
                    CountryParser.parseLanguage(jsonLang);
                    break;
                case 4:
                    String jsonCountries = clientHttp.getAll();
                    CountryParser.parseAll(jsonCountries);
                    break;
                case 0:
                    System.out.println(" -------------------------- Program finalized. ----------------------------");
                    exit = true;

                    break;
                default:
                    System.out.println("Try another number, please one that is included in the menu! ");
            }

        } while (!exit);
    }
}