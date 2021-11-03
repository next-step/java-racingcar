package validator;
import calculator.Operator;
import utils.IntUtils;

public class OperatorValidator implements IValidator {

    @Override
    public void check(String input) {
        String[] inputArr = input.split(" ");
        for(int i = 0 ; i < inputArr.length; i++){
            if(i % 2 == 0) isNumber(inputArr[i]);
            if(i % 2 == 1) isOperator(inputArr[i]);
        }
    }

    private void isOperator(String str) {
        if(!Operator.isOperator(str)) throw new IllegalArgumentException("operator is invalid");
    }

    private void isNumber(String str) {
        if(!IntUtils.isInt(str)) throw new IllegalArgumentException("number format is invalid");
    }
}