import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ClientsData {
    private final String name;
    private final String lastName;
    private final String nip;
    List<Article[]> fakturki;
    private static int free_client_index = 0;
    private int client_id;

    public String getName (){
        return this.name;
    }

    public String getLastName (){
        return this.lastName;
    }

    public String getNip (){
        return this.nip;
    }

    public Article[] getFakturka (int id_fakturki){
        return this.fakturki.get(id_fakturki);
    }

    public ClientsData(String name, String lastName, String nip) {
        this.name = name;
        this.lastName = lastName;
        this.nip = nip;
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


    public double collectComponents(String name, String lastName, String nip, Article[] articles) {
        System.out.println("Dane odbiorycy faktury: " + name + " " + lastName + " nip: " + nip);
        System.out.println("towar  ;  ilość  ;  cena netto  ;  cena brutto");
        double totalValue = 0.0D;

        for(int i = 1; i <= articles.length; ++i) {
            double bruttoVal = (double)articles[i - 1].getQuant() * articles[i - 1].getPrice(); //funkcją pobieram cenę jednostkową i ilość
            double nettoVal = Math.round(((double)articles[i - 1].getQuant() * articles[i - 1].getPrice() / Constants.VAT) * 100.0) / 100.0;
            ArticleGroup var10001 = articles[i - 1].getComponentType();
            System.out.println(var10001 + " ; " + articles[i - 1].getQuant() + " ; " + nettoVal + " ; " + bruttoVal);
            totalValue += bruttoVal;
        }

        System.out.println("Suma do zapłaty: " + totalValue);
        return totalValue;
    }
}
