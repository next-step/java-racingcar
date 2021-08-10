import java.util.regex.Pattern;

class StringCalculator {

    private String formula;
    private int result = 0;
    private Operator currentOperator = Operator.PLUS;

    public int calculateFormula(){
        for(String input : formula.split(" ")){
            calculatePartial(input);
        }

        return result;
    }

    public void setFormula(String formula){
        this.formula = formula;
    }

    private void calculatePartial(String input){

       final String regExp = "^[0-9]*$";

        if(Pattern.matches(regExp, input)){
            result = currentOperator.operate(result, Integer.parseInt(input));
            return;
        }

        for(Operator operator : Operator.values()){
            if(operator.getSymbol().equals(input)){
                currentOperator = operator;
                return;
            }
        }

        throw new IllegalArgumentException();

    }
}