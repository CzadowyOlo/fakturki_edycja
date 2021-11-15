import java.io.PrintStream;

public class ClientsData {
    private final String name;
    private final String lastName;
    private Components[][] fakturki;
    private static int free_client_index;

    public ClientsData(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        //this.components = components;
    }

    public void addFakturka (Components[] components){

    }

    public double getSumOfComponents(String name, String lastName, Components[] components) {
        System.out.println("Dane odbiorycy faktury: " + name + " " + lastName);
        System.out.println("towar | ilość | cena netto | cena brutto");
        double totalValue = 0.0D;

        for(int i = 1; i <= components.length; ++i) {
            double bruttoValue = (double)components[i - 1].getQuantity() * components[i - 1].getValue(); //funkcją pobieram cenę jednostkową i ilość
            double netValue = Math.round(((double)components[i - 1].getQuantity() * components[i - 1].getValue() / Constants.VAT) * 100.0) / 100.0;
            PrintStream var10000 = System.out;
            ComponentType var10001 = components[i - 1].getComponentType();
            var10000.println(var10001 + "    " + components[i - 1].getQuantity() + "    " + netValue + "    " + bruttoValue);
            totalValue += bruttoValue;
        }

        System.out.println("Suma do zapłaty: " + totalValue);
        return totalValue;
    }
}
