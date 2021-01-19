import calculator.Calculator;
import calculator.CalculatorImpl;

import java.util.List;

public class CalculatorMain {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        calculator.printInputInformation();
        List<String> inputDatas = calculator.input();
        calculator.calculate(inputDatas);
    }
}