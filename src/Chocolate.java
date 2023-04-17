public class Chocolate extends Product{

    private String taste;
    public Chocolate(String name, double price, double value, String taste) {
        super(name, price, value);
        this.taste = taste;
    }

    @Override
    public String toString() {
        return String.format("Шоколад со вкусом %s, %s", taste, super.toString());
    }
}
