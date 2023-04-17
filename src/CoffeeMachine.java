public class CoffeeMachine extends VendingMachine {
    private Water water;
    private Milk milk;
    private Shugar shugar;
    private Coffee coffee;

    public CoffeeMachine(Water water, Milk milk, Shugar shugar, Coffee coffee) {
        this.water = water;
        this.water.setVolume(this.water.getVolume() * 1000);
        this.milk = milk;
        this.shugar = shugar;
        this.coffee = coffee;
    }

//    public CoffeeMachine() {
//        this.water = null;
//        this.milk = null;
//        this.shugar = null;
//        this.coffee = null;
//    }

    public void setWater(double volumeLitres) {
        if (this.water.getVolume()>0){
            this.water.setVolume((this.water.getVolume())+volumeLitres*1000);
        }
        else {
            this.water = new Water(volumeLitres);
            this.water.setVolume(water.getVolume() * 1000);
        }
    }

    public void setMilk(String name, double price, double value) {
        this.milk = new Milk(name, price / 1000, (value)+this.milk.getCounter()); // переводим цену в цену за мл, а объем - в мл.
    }

    public void setShugar(Shugar shugar) {
        if (this.shugar == null || this.shugar.getCounter()==0) {
            this.shugar = shugar;
        }
        else {
            double counter = (this.shugar.getCounter()+shugar.getCounter());
            shugar = new Shugar(shugar.getName(),shugar.getPrice(),counter);
        }
        this.shugar.addCounter(shugar.getCounter()); // переводим килограммы в граммы
        this.shugar.setPrice(shugar.getPrice() / 1000); // цена за грамм
    }

    public void setCoffee(Coffee coffee) {
        if (this.coffee == null || this.coffee.getCounter()==0) {
            this.coffee = coffee;
        }
        else {
            double counter = (this.coffee.getCounter()+coffee.getCounter());
            coffee = new Arabica(coffee.getName(), coffee.getPrice(), counter);
        }
        this.coffee.addCounter(coffee.getCounter());
        this.coffee.setPrice(coffee.getPrice() / 1000);
    }

    public void warmer() {
        this.water.setTemperature(98);
    }

    public Drink getByReciept(String name, int cofee, int sugar, int water, int milk) {
        if (this.water.getTemperature() < 75) {
            System.out.printf("Вода остыла до %.1f градусов. Греем...\n", this.water.getTemperature());
            warmer();
            System.out.printf("Нагрели до %.1f начинаем приготовление", this.water.getTemperature());
            System.out.println();
        }

        int dose = 0;
        while (dose <= cofee) {
            this.coffee.sellCounterByGramm();
            dose++;
        }
        System.out.println("Помололи кофе");
        dose = 0;
        while (dose <= sugar) {
            this.shugar.sellCounterByGramm();
            dose++;
        }
        System.out.println("Насыпали сахар");
        dose = 0;
        while (dose <= water) {
            this.water.setVolume(this.water.getVolume() - 1);
            dose++;
        }
        System.out.printf("Налили кипяток (%.1f) градусов.\n", this.water.getTemperature());
        dose = 0;
        while (dose <= milk) {
            this.milk.sellCounterByGramm();
            dose++;
        }
        if (milk>0) System.out.println("Добавили молоко");
        double temperature = ((water * this.water.getTemperature() + milk * this.milk.getTemperature()) / (water + milk) - 4.2);
//        System.out.println(this.water.getTemperature());
        Drink res = new Drink(name, water + milk, temperature, (((this.coffee.getPrice() / 1000) * cofee * 10) + ((this.shugar.getPrice() / 1000) * sugar * 5) + ((this.milk.getPrice() / 1000) * milk * 2)));
//        System.out.println(res.toString());
//        super.addProduct(res);
        this.water.setTemperature(this.water.getTemperature() - 9.7);
//        System.out.println(this.water.getTemperature());
        return res;
    }

    public Drink getCappuccino() {
        Drink cappuccino = getByReciept("капучино", 3, 5, 150, 50);
        return cappuccino;
    }

    public Drink getLatte() {
        Drink latte = getByReciept("Латте", 2, 7, 100, 100);
        return latte;
    }

    public Drink getEspresso() {
        Drink espresso = getByReciept("Эспрессо", 4, 4, 50, 0);
        return espresso;
    }

    public Drink getAmericano() {
        Drink americano = getByReciept("Американо", 4, 5, 150, 0);
        return americano;
    }

    public void service(){

        // TODO: пересмотреть логику в сторону адекватности

        System.out.println("Сейчас в аппарате:");
        System.out.println(this);
        String coffName = input.Str("Введите название кофе");
        Double coffPrice = input.Double("Сколько стоит килограмм?");
        Double coffValue = input.Double("Введите вес кофе в кг");
        this.setCoffee(new Arabica(coffName, coffPrice, coffValue));
        String milkName = input.Str("Введите название молока");
        Double milkPrice = input.Double("Сколько стоит литр?");
        Double milkValue = input.Double("Введите объем молока в л");
        this.setMilk(milkName, milkPrice, milkValue);
        String sugarName = input.Str("Введите название сахара");
        Double sugarPrice = input.Double("Сколько стоит килограмм?");
        Double sugarValue = input.Double("Введите вес сахара в кг");
        this.setShugar(new Shugar(sugarName, sugarPrice, sugarValue));
        Double waterValue = input.Double("Сколько литров воды зальём?");
        this.setWater(waterValue);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("| Вода: %.2f л            |\n", this.water.getVolume() / 1000))
                .append(String.format("| Молоко: %.2f л\n", this.milk.getCounter()))
                .append(String.format("| Кофе: %.2f кг\n", this.coffee.getCounter()))
                .append(String.format("| Сахар: %.2f кг\n", this.shugar.getCounter()))
                .append(String.format("*--- температура: %.1f  ---*", this.water.getTemperature()));
        return res.toString();
    }
}
