public class Main {
    public static void main(String[] args) {
        VendingMachine mart = new VendingMachine();
        mart.addProduct(new Product("Хлеб", 35, 10))
                .addProduct(new Milk("Белоснежка", 50, 2))
                .addProduct(new Product("Сыр", 100.2, 5))
                .addProduct(new ConcentrateMilk("Советская", 150, 1))
                .addProduct(new Chocolate("Аленка", 35.20,3, "Ореховый"))
                .addProduct(new Arabica("Lavatsa", 800, 1));
//        System.out.println("До продажи");

//        System.out.println(mart);
//        PrintSell(mart,"moloko");
//        PrintSell(mart,"moloko");
//        PrintSell(mart,"moloko");
//        System.out.println();
//        System.out.println("После продажи");
//        System.out.println(mart);
//        System.out.println();
//        PrintSell(mart,"Фиговина");

//        System.out.println(mart);
//        PrintSell(mart, "капучино");
//        PrintSell(mart, "латте");
//        PrintSell(mart, "американо");
//        PrintSell(mart, "эспрессо");
//        System.out.println(mart);
        menu(mart);
    }

    public static void PrintSell(VendingMachine machine, String nameProd) {
        try {
            System.out.println(machine.sell(nameProd));
        } catch (Exception e) {
            System.out.println("Товар не найден");
        }
    }

    public static void buy(VendingMachine machine){
        String order = input.Str("Введите название товара");
        PrintSell(machine, order);
    }

    public static void menu(VendingMachine machineName) {
        System.out.println("Добро пожаловать!");
        StringBuilder gui = new StringBuilder();
        gui
                // Существует ли в Java метод для чистки консоли?
                .append("\n\nг----Выберите действие:-----|\n")
                .append("|\t1. Совершить покупку    |\n")
                .append("|\t2. Прайс торгомата      |\n")
                .append("|---------------------------|\n")
                .append("+-------сервисное меню------+\n")
                .append("|\t3. Состояние торгомата  |\n")
                .append("|\t4. Добавить товар       |\n")
                .append("|\t5. Заправить кофемашину |\n")
                .append("|___________________________|");
        while (true) {
            int choise = input.Int(gui.toString());
            switch (choise) {
                case 1:
                    buy(machineName);
                    break;
                case 2:
                    machineName.getPriceList();
                    break;
                case 3:
                    System.out.println(machineName.toString());
                    break;
                case 4:
                    machineName.addProduct();
                    break;
                case 5:
                    machineName.coffeeService();
                    break;
            }

        }
    }
}