package stringcalculator;

public class ExpressionFactory {

    private static final String DELIMITER = " ";

    private static final int PARSING_LENGTH=2;

    public Expression create(String input) {

        return parseStringIntoExpression(input);
    }

    private Expression parseStringIntoExpression(String input){

        validateWhetherNullOrEmpty(input);

        String[] split = input.split(DELIMITER);

        if(split.length<1) throw new IllegalArgumentException("input is too short to parse ");

        Expression lastExpression = new NoneExpression(split[0]);

        for (int i = 1; i < split.length; i += PARSING_LENGTH) {

            if(split.length < i+PARSING_LENGTH) throw new IllegalArgumentException("input is too short to parse");

            lastExpression = createSpecificExpression(lastExpression, split[i], new NoneExpression(split[i + 1]));
        }

        return lastExpression;
    }

    private Expression createSpecificExpression(Expression firstExpression, String symbol, Expression secondExpression) {
        if (Operator.getBySymbol(symbol) == Operator.ADDITION) {
            return new AdditionExpression(firstExpression, secondExpression);
        }

        if (Operator.getBySymbol(symbol) == Operator.SUBTRACTION) {
            return new SubtractionExpression(firstExpression, secondExpression);
        }

        if (Operator.getBySymbol(symbol) == Operator.MULTIPLICATION) {
            return new MultiplicationExpression(firstExpression, secondExpression);
        }

        if (Operator.getBySymbol(symbol) == Operator.DIVISION) {
            return new DivisionExpression(firstExpression, secondExpression);
        }

        throw new IllegalArgumentException(symbol+" has no valid expression");
    }

    private void validateWhetherNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) throw new IllegalArgumentException("invalid input");
    }
}
