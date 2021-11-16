import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ClientsData {
    private final String name;
    private final String lastName;
    List<Article[]> fakturki;
    private static int free_client_index = 0;
    private int client_id;

    public String getName (){
        return this.name;
    }

    public String getLastName (){
        return this.lastName;
    }

    public Article[] getFakturka (int id_fakturki){
        return this.fakturki.get(id_fakturki);
    }

    public ClientsData(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.fakturki = new ArrayList<Article[]>();
        this.client_id = free_client_index;
        free_client_index++;
    }

    public int addFakturka (Article[] components){
        this.fakturki.add(components);
        return (fakturki.size() - 1);

    }

    public int getClientId(){

        return this.client_id;
    }


    public double getSumOfComponents(String name, String lastName, Article[] components) {
        System.out.println("Dane odbiorycy faktury: " + name + " " + lastName);
        System.out.println("towar | ilość | cena netto | cena brutto");
        double totalValue = 0.0D;

        for(int i = 1; i <= components.length; ++i) {
            double bruttoValue = (double)components[i - 1].getQuant() * components[i - 1].getPrice(); //funkcją pobieram cenę jednostkową i ilość
            double netValue = Math.round(((double)components[i - 1].getQuant() * components[i - 1].getPrice() / Constants.VAT) * 100.0) / 100.0;
            PrintStream var10000 = System.out;
            ArticleGroup var10001 = components[i - 1].getComponentType();
            var10000.println(var10001 + "    " + components[i - 1].getQuant() + "    " + netValue + "    " + bruttoValue);
            totalValue += bruttoValue;
        }

        System.out.println("Suma do zapłaty: " + totalValue);
        return totalValue;
    }
}
