public class Croissant extends Product{

    public Croissant(String name, double price, int value) {
        super(name, price, value);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Французский: ")
                .append(super.toString());
        return res.toString();
    }
}

