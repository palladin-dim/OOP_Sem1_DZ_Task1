public class Product {
    private String name;
    private double price;
    private double counter;

    public Product(String name, double price, double value) {
        this.name = name;
        this.price = price;
        this.counter=value;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean sellCounter() {
        this.counter--;
        return counter>0;
    }

    public boolean sellCounterByGramm() {
        this.counter-= this.counter/1000;
        return counter>0;
    }

    public void addCounter(double value) {
        this.counter = value;
    }

    public double getCounter() {
        return this.counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f р.", name, price);
    }
}
