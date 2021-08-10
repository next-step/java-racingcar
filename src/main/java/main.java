public class main {
    public static void calulatorMain(String[] args) {
        StringCalculator calculator = new StringCalculator();
        String cacularNumber = "2 + 3 * 4 / 2";
        calculator.setFormula(cacularNumber);

        System.out.println("::cacularNumber::" +calculator.calculateFormula());
    }
}
