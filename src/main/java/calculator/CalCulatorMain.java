package calculator;

public class CalCulatorMain {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        System.out.println(calculator.solve("25 + 8 + 9 / 2 / 3 / 3 * 2"));
    }
}
