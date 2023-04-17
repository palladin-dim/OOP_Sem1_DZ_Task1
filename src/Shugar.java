public class Shugar extends Product{
    public Shugar(String name, double price, Double value) {
        super(name, price, value);
    }

    @Override
    public String toString() {
        return String.format("Сахар : %s" ,super.toString());
    }
}
