import step1.calculator.StringCalculator;
import step1.racing.ReadyStage;
import step2.StringCalculator.IntegerAdder;

public class Main {
    public static void main(String[] args) {
        String equation = "//;\\n1;2;3";
        IntegerAdder adder = new IntegerAdder(equation);
        System.out.println(adder.calculate());
    }
}
