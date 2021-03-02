package stringcalculator;

public class ExpressionFactory {

    private final String DELIMITER = " ";

    public Expression create(String input) {
        validateInput(input);
        
        String[] split = input.split(DELIMITER);

        isParsable(split,3);
        Expression lastExpression = createSpecificExpression(new NoneExpression(split[0]), split[1], new NoneExpression(split[2]));

        for (int i = 3; i < split.length; i += 2) {
            isParsable(split,i+2);
            lastExpression = createSpecificExpression(lastExpression, split[i], new NoneExpression(split[i + 1]));
        }
        return lastExpression;
    }

    private void isParsable(String[] split,int minimumLength){
        if(split.length<minimumLength) throw new IllegalArgumentException();
    }

    private Expression createSpecificExpression(Expression firstExpression, String symbol, Expression secondExpression) {
        if (symbol.equals(Operator.ADDITION.getSymbol())) {
            return new AdditionExpression(firstExpression, secondExpression);
        }

        if (symbol.equals(Operator.SUBTRACTION.getSymbol())) {
            return new SubtractionExpression(firstExpression, secondExpression);
        }

        if (symbol.equals(Operator.MULTIPLICATION.getSymbol())) {
            return new MultiplicationExpression(firstExpression, secondExpression);
        }

        if (symbol.equals(Operator.DIVISION.getSymbol())) {
            return new DivisionExpression(firstExpression, secondExpression);
        }

        throw new IllegalArgumentException(symbol+" is not valid symbol");
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) throw new IllegalArgumentException("invalid input");
    }
}
