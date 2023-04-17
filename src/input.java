import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class input {
    static Scanner input = new Scanner(System.in);
    public static int Int(String usersText){
        try {
            System.out.println(usersText);
            int value = input.nextInt();
            return value;
        } catch (InputMismatchException e){
            System.out.println("Слишком длинное число...");
            return 0;
        }
    }

    /**
     * неуниверсальный метод захвата строки
     * @param usersText
     * @return
     */
    public static String Str(String usersText){
        System.out.println(usersText);
//        String value = input.next();
//        value += " ";
//        value += input.next();
        return (input.next());
//        return value;
    }

    public static double Double(String usersText) {
        System.out.println(usersText);
        double value = java.lang.Double.parseDouble(input.next());
        return value;
    }

    public static long Long(String usersText) {
        System.out.println(usersText);
        long value = java.lang.Long.parseLong(input.next());
        return value;
    }

}