public class ConcentrateMilk extends Milk {

    public ConcentrateMilk(String name, double price, int value) {
        super(name, price, value);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Сгуха: ")
                .append(super.toString());
        return res.toString();
    }
}
