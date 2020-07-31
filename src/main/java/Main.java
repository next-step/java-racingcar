import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArithmeticReader reader = new ArithmeticReader();

        try {
            String expression = reader.read();

            int result = Calculator.calculate(new ArithmeticArguments(expression));

            System.out.println(result);
        } catch (ArithmeticFormatException e) {
            System.out.println("Not Arithmetic Expression");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
