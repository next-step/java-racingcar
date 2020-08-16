package step2;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        String formula = "2 + 3 * 4 / 2";
        calculator.setFormula(formula);

        System.out.println(calculator.calculateFormula());
    }
}
