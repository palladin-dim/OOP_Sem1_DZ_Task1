public class Water {
    private double volume;
    private double temperature;

    public Water(double volume) {
        this.volume = volume;
        this.temperature = 18;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        // todo: Имплементировать остывание
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Вода: \n")
                .append("остаток: ")
                .append(volume)
                .append("\n")
                .append("t: ")
                .append(temperature);
        return res.toString();
    }

    public void cool() {
        // TODO: Реализовать метод остывания
        while (this.temperature > 18) {
            long timeH = System.currentTimeMillis();
            long timeC;
            while (true) {
                timeC = System.currentTimeMillis();
                if ((timeH - timeC) > this.volume) {
                    this.temperature--;
                }
            }
        }
    }
}
