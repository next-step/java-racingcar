
public class StringCalculator {

    CalculatorContext calculatorContext;

    public StringCalculator() {
        this.calculatorContext = new CalculatorContext();
    }

    public Integer run(String input) {
        validateInput(input);


        for (String rawToken : input.split(" +")) {
            Token token = new Token(rawToken);
            calculatorContext.take(token);
        }

        return calculatorContext.result;
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null 이네요");
        }
        if (input.replaceAll(" ", "").length() == 0) {
            throw new IllegalArgumentException("입력이 텅텅 비었네요");
        }
    }
}
