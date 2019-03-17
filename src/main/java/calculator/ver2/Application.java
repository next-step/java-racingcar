package calculator.ver2;

public class Application {
    public static void main(String[] args) {
        String text = InputHandler.input();
        PositiveNumber result = StringAdditionCalculator.calculate(text);
        result.print();
    }
}
