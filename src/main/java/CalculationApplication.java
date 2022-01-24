import calculator.Calculator;
import calculator.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculationApplication {

    public static void main(String[] args) throws IOException {
        calculateString();
    }

    public static void calculateString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Validator validator = new Validator();
        String[] input = validator.stringCheck(br.readLine());

        Calculator calculator = new Calculator();
        System.out.println(calculator.execute(input));
    }
}
