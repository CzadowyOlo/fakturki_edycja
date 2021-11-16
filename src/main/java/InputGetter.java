import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputGetter {


    List<ClientsData> array_of_clients = new ArrayList<ClientsData>();

    public InputGetter() {
    }

    public ClientsData addClient(){
        Scanner in = new Scanner(System.in);
        String name = this.readName(in);
        String lastName = this.readLastName(in);
        ClientsData new_client = new ClientsData(name, lastName);
        array_of_clients.add(new_client);
        System.out.println("Your Client ID: " + new_client.getClientId());
        return new_client;
    }

    public void print_Fakturka(int clientId, int fakturkaId){
        ClientsData client = array_of_clients.get(clientId);
        client.getSumOfComponents(client.getName(), client.getLastName(), client.getFakturka(fakturkaId));
    }

    public  void addFakturka(int client_id){
        Scanner in = new Scanner(System.in);
        Article[] components = this.getComponents(in);
        int fakturka_index = array_of_clients.get(client_id).addFakturka(components);
        System.out.println("Your Fakturka Id: " + fakturka_index);
    }

    private String readName(Scanner in) {
        String input;
        System.out.println("Enter your name");
        input = in.next();
        return input;
    }

    private String readLastName(Scanner in) {
        String input;
        System.out.println("Enter your last name");
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
        System.out.println("How many components have you ordered?");
        input = in.next();
        return Integer.parseInt(input);
    }

    private ArticleGroup getComponentType(Scanner in, int i) {
        String componentInput;
        do {
            System.out.println("Enter type of component" + i + this.generateComponentTypeElements());
            componentInput = in.next();
        } while(EnumValidator.validateComponentType(componentInput));

        return ArticleGroup.valueOf(componentInput);
    }

    private int getQuantityOfComponents(Scanner in, int i) {
        String componentInput;
        System.out.println("Enter quantity of component " + i);
        componentInput = in.next();
        return Integer.parseInt(componentInput);
    }

    private double getValueOfComponent(Scanner in, int i) {
        String componentInput;
        System.out.println("Enter (brutto)value of ordered component " + i);
        componentInput = in.next();
        return Double.parseDouble(componentInput);
    }

    private String generateComponentTypeElements() {
        String elements = "(";

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
