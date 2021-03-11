package operator;

import java.util.Optional;

public class OperatorFactory {

    public static Optional<Operator> getOperator(String operator){
        if(operator.equals("+")) return Optional.of(new PlusOperator());
        if(operator.equals("-")) return Optional.of(new MinusOperator());
        if(operator.equals("*")) return Optional.of(new MultiplicationOperator());
        if(operator.equals("/")) return Optional.of(new DivisionOperator());
        return Optional.empty();
    }

}
