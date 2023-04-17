public abstract class Coffee extends Product{
    public Coffee(String name, double price, double value) {
        super(name, price, value);
    }

    @Override
    public String toString() {
        return String.format("Кофе : %s" ,super.toString());
    }
}
