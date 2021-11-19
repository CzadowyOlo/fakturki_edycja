public class Article {
    private final ArticleGroup articleGroup;
    private final double price;
    private final int quant;

    public Article(ArticleGroup articleGroup, double price, int quant) {
        this.articleGroup = articleGroup;
        this.price = price;
        this.quant = quant;
    }

    public ArticleGroup getComponentGroup() {
        return this.articleGroup;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuant() {
        return this.quant;
    }
}
