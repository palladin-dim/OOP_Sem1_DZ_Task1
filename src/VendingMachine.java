import java.util.ArrayList;
import java.util.List;


public class VendingMachine {
    private List<Product> products = new ArrayList<>();
    private double money = 0;

    private static CoffeeMachine lavatsa = new CoffeeMachine
            (
                    new Water(20),
                    new Milk("Молоко для кофе", 85, 5.0),
                    new Shugar("Русский сахар", 65, 5.0),
                    new Arabica("Lavatsa", 800, 3.0)
            );


    public VendingMachine addProduct(Product product) {
        products.add(product);
        System.out.printf("Добавили в автомат %s \n", product);
        return this;
    }

    public VendingMachine addProduct() {
        int type = input.Int
                (
                        "Выберите категорию продукта:\n" +
                                "1-молоко\n" +
                                "2-сахар\n" +
                                "3-шоколад\n" +
                                "4-кофе\n" +
                                "5-другой продукт\n" +
                                "6-напиток\n"
                );
        String name = input.Str("Введите название продукта:\n");
        double price = input.Double("Укажите цену\n");
        double value = input.Double("Введите количество\n");
        if (type==1){
            products.add(new Milk(name,price,value));
        } else if (type==2) {
            products.add(new Shugar(name,price,value));
        } else if (type==3) {
            String taste = input.Str("Уточните вкус");
            products.add(new Chocolate(name,price,value,taste));
        } else if (type==4) {
            products.add(new Arabica(name,price,value));
        } else if (type==5) {
            products.add(new Product(name,price,value));
        } else if (type==6) {
            products.add(new Drink(name,value,18,price));
        }
        return this;
    }

    public void coffeeService (){
        lavatsa.service();
    }

    public Product searchProduct(String name) {
        if (name.equalsIgnoreCase("капучино")) {
            this.addProduct(lavatsa.getCappuccino());
        }
        if (name.equalsIgnoreCase("латте")) {
            products.add(lavatsa.getLatte());
        }
        if (name.equalsIgnoreCase("эспрессо") || name.equalsIgnoreCase("кофе")) {
            products.add(lavatsa.getEspresso());
        }
        if (name.equalsIgnoreCase("американо")) {
            products.add(lavatsa.getAmericano());
        }

        for (Product item : products) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
//            else System.out.println("FALSE");
        }

        return null;
    }

    public Product sell(String name) throws Exception {
        Product target = searchProduct(name);
        try {
            if (!target.sellCounter()) {
                products.remove(target);

            }
            this.money += target.getPrice();
        } catch (NullPointerException e) {
//            System.out.println("Товар не найден");
            throw new Exception("Товар не найден", e);
        }

        return target;
    }

    public void getPriceList (){
        int id = 1;
        for (Product item:this.products) {
            System.out.printf("%d. %s %s - %.2fруб. Осталось: %.0f\n",id,item.getClass().getName(),item.getName(),item.getPrice(),item.getCounter());
            id++;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("*--------------------------*\n|   Список товаров:        |\n");
        for (Product item : products) {
            res.append("| ")
                    .append(item)
                    .append("\n");
        }
        res.append("\n*---Загрузка кофемашины:---*\n")
                .append(lavatsa.toString())
                .append("\n")
                .append(String.format("В автомате сейчас %.2f рублей", money));
        return res.toString();
    }
}
