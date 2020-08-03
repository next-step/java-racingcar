public class CalculatorMain {

    public static void main(String[] args) {
        Calculator calcInstance = new Calculator();
        String value = "1 + 6 - 2 * 5";
        System.out.println(calcInstance.totalCalculate(value));
    }
}
