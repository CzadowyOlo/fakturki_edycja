import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    public void print_Options(){
    }

    List<ClientsData> array_of_clients = new ArrayList<ClientsData>();

    public ConsoleReader() {
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
        Components[] components = this.getComponents(in);
        int fakturka_index = array_of_clients.get(client_id).addFakturka(components);
        System.out.println("Your Fakturka Id: " + fakturka_index);
    }

   /* public ClientsData read() {
        Scanner in = new Scanner(System.in);
        String name = this.getName(in);
        String lastName = this.getLastName(in);
        Components[] components = this.getComponents(in);
        ClientsData clientsData = new ClientsData(name, lastName, components); //pozniej
        clientsData.getSumOfComponents(name, lastName, components);
        return clientsData;
    }
    */

    private String readName(Scanner in) {
        String input;
        do {
            System.out.println("Enter your name");
            input = in.next();
        } while(!StringValidator.validateString(input, "[A-ZĄ-Ź][a-zą-ź]{2,9}"));

        return input;
    }

    private String readLastName(Scanner in) {
        String input;
        do {
            System.out.println("Enter your last name");
            input = in.next();
        } while(!StringValidator.validateString(input, "([A-ZĄ-Ź][a-zaą-ź]+)([\\s-]([A-ZĄ-Ź][a-zaą-ź]+))?"));

        return input;
    }

    private Components[] getComponents(Scanner in) {
        int numOfComponents = this.getNumOfComponents(in);
        Components[] components = new Components[numOfComponents];

        for(int i = 1; i <= numOfComponents; ++i) {
            ComponentType component = this.getComponentType(in, i);
            int quantityOfComponents = this.getQuantityOfComponents(in, i);
            double componentValue = this.getValueOfComponent(in, i);
            Components component1 = new Components(component, componentValue, quantityOfComponents);
            components[i - 1] = component1;
        }

        return components;
    }

    private int getNumOfComponents(Scanner in) {
        String input;
        do {
            System.out.println("How many components have you ordered?");
            input = in.next();
        } while(!NumberValidator.validateInteger(input, 1, 2147483647));

        int numOfComponents = Integer.valueOf(input);
        return numOfComponents;
    }

    private ComponentType getComponentType(Scanner in, int i) {
        String componentInput;
        do {
            System.out.println("Enter type of component" + i + this.generateComponentTypeElements());
            componentInput = in.next();
        } while(EnumValidator.validateComponentType(componentInput));

        ComponentType component = ComponentType.valueOf(componentInput);
        return component;
    }

    private int getQuantityOfComponents(Scanner in, int i) {
        String componentInput;
        do {
            System.out.println("Enter quantity of component " + i);
            componentInput = in.next();
        } while(!NumberValidator.validateInteger(componentInput, 1, 2147483647));

        int quantity = Integer.valueOf(componentInput);
        return quantity;
    }

    private double getValueOfComponent(Scanner in, int i) {
        String componentInput;
        do {
            System.out.println("Enter (brutto)value of ordered component " + i);
            componentInput = in.next();
        } while(!NumberValidator.validateDouble(componentInput, 1.0D, 1.7976931348623157E308D));

        double value = Double.valueOf(componentInput);
        return value;
    }

    private String generateComponentTypeElements() {
        String elements = "(";

        for(int i = 0; i < ComponentType.values().length; ++i) {
            elements = elements + ComponentType.values()[i].name();
            if (i < ComponentType.values().length - 1) {
                elements = elements + ", ";
            }
        }

        elements = elements + ")";
        return elements;
    }
}
