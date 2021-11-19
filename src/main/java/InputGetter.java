import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputGetter {
//

    List<ClientsData> array_of_clients = new ArrayList<ClientsData>();

    public InputGetter() {
    }

    public ClientsData addClient(){
        Scanner in = new Scanner(System.in);
        String name = this.readName(in);
        String lastName = this.readLastName(in);
        String nip = this.readNip(in);
        ClientsData new_client = new ClientsData(name, lastName, nip); //stworzenie klienta
        array_of_clients.add(new_client); //wpisanie go do listy klientów
        System.out.println("Your Client ID: " + new_client.getClientId());
        return new_client;
    }

    public void print_Fakturka(int clientId, int fakturkaId){
        ClientsData client = array_of_clients.get(clientId);
        client.collectComponents(client.getName(), client.getLastName(), client.getNip(), client.getFakturka(fakturkaId));
    }

    public  void addFakturka(int client_id){
        Scanner in = new Scanner(System.in);
        Article[] components = this.getComponents(in);
        int fakturka_index = array_of_clients.get(client_id).addFakturka(components);
        System.out.println("Your Fakturka Id: " + fakturka_index);
    }

    private String readName(Scanner in) {
        String input;
        System.out.println("Wprowadź imię clienta");
        input = in.next();
        return input;
    }

    private String readLastName(Scanner in) {
        String input;
        System.out.println("Wprowadź nazwisko clienta");
        input = in.next();
        return input;
    }

    private String readNip(Scanner in) {
        String input;
        System.out.println("Wprowadź nip clienta");
        input = in.next();
        return input;
    }

    private Article[] getComponents(Scanner in) {
        int numOfComponents = this.getNumOfComponents(in);
        Article[] components = new Article[numOfComponents];

        for(int i = 1; i <= numOfComponents; ++i) {
            ArticleGroup component = this.getComponentType(in, i);
            int quantityOfComponents = this.getQuantityOfComponents(in, i);
            double componentValue = this.getValueOfComponent(in, i);
            Article component1 = new Article(component, componentValue, quantityOfComponents);
            components[i - 1] = component1;
        }

        return components;
    }

    private int getNumOfComponents(Scanner in) {
        String input;
        System.out.println("Ile różnych artykółów kupiono?");
        input = in.next();
        return Integer.parseInt(input);
    }

    private ArticleGroup getComponentType(Scanner in, int i) {
        String componentInput;
        do {
            System.out.println("Podaj nazwę artykułu nr: " + i + this.showListOfArticleGroups());
            componentInput = in.next();
        } while(EnumValidator.validateComponentType(componentInput));

        return ArticleGroup.valueOf(componentInput);
    }

    private int getQuantityOfComponents(Scanner in, int i) {
        String componentInput;
        System.out.println("Podaj ilość artykułu nr: " + i);
        componentInput = in.next();
        return Integer.parseInt(componentInput);
    }

    private double getValueOfComponent(Scanner in, int i) {
        String componentInput;
        System.out.println("Podaj cenę brutto za sztukę artykułu nr: " + i);
        componentInput = in.next();
        return Double.parseDouble(componentInput);
    }

    private String showListOfArticleGroups() {
        String elements = " (";

        for(int i = 0; i < ArticleGroup.values().length; ++i) {
            elements = elements + ArticleGroup.values()[i].name();
            if (i < ArticleGroup.values().length - 1) {
                elements = elements + ", ";
            }
        }

        elements = elements + ")";
        return elements;
    }
}
