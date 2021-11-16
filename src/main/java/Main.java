import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public Main() {
    }

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        //consoleReader.read();
        boolean active_loop = true;
        while (active_loop){
            System.out.println("1. Dodaj clienta");
            System.out.println("2. Dodaj fakturke");
            System.out.println("3. Wyświetl fakturke");
            System.out.print("Wybór: ");
            String choose;
            Scanner in = new Scanner(System.in);
            choose = in.next();
            switch (choose){
                case "1":
                    consoleReader.addClient();
                    break;
                case "2":
                    System.out.println("Podaj Id clienta:");
                    consoleReader.addFakturka(Integer.parseInt(in.next()));
                    break;
                case "3":
                    System.out.println("Podaj Id clienta:");
                    int client_id = Integer.parseInt(in.next());
                    System.out.println("Podaj Id fakturki:");
                    int fakturka_id = Integer.parseInt(in.next());
                    consoleReader.print_Fakturka(client_id, fakturka_id);
                    break;
                default:
                    active_loop = false;
                    break;


            }

        }


    }
}