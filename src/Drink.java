public class Drink extends Product {
    double volume;
    double temperature;


    public Drink(String name, double volume, double temperature, double price) {
        super(name, price, 1);
        this.volume = volume;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(super.getName())
                .append("\n");
        if (volume < 1000) {
            res.append(String.format("%.0f мл, %.1f*C \n", volume, temperature));
        } else {
            res.append(String.format("%.2f л, %.1f*C \n", volume / 1000, temperature));
        }
        res.append(String.format("%.2f", super.getPrice()))
                .append("р. \n");
        return res.toString();
    }
}
