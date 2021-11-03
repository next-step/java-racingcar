package validator;
import calculator.Operator;
import utils.IntUtils;

public class OperatorValidator implements IValidator {

    @Override
    public void check(String input) {
        String[] inputArr = input.split(" ");
        for(int i = 0 ; i < inputArr.length; i++){
            if(i % 2 == 0) isNumber(inputArr[i]);
            else isOperator(inputArr[i]);
        }
    }

    private void isOperator(String s) {
        if(!Operator.isOperator(s)) throw new IllegalArgumentException("operator is invalid");
    }

    private void isNumber(String s) {
        if(!IntUtils.isInt(s)) throw new IllegalArgumentException("number format is invalid");
    }
}
