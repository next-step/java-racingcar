import calculator.Calculator;
import calculator.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculationApplication {

    public static void main(String[] args) throws IOException {
        calculate();
    }

    public static void calculate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = Validator.stringCheck(br.readLine());

        Calculator calculator = new Calculator(input);
        calculator.execute();
        System.out.println(calculator.getResult());
    }
}
