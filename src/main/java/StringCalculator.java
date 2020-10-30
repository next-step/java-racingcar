
public class StringCalculator {

    private CalculatorContext calculatorContext;

    public StringCalculator() {
        this.calculatorContext = new CalculatorContext();
    }

    public Integer run(String input) {
        validateInput(input);

        for (String rawValue: input.split(" +")) {
            Token token = TokenFactory.buildToken(rawValue);
            calculatorContext.takeNextToken(token);
        }

        return calculatorContext.getResult();
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null 이네요");
        }
        if (input.trim().equals("")) {
            throw new IllegalArgumentException("입력이 텅텅 비었네요");
        }
    }
}
