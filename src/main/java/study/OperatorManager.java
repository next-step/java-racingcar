package study;

import java.util.HashMap;
import java.util.Map;

public class OperatorManager {
    public HashMap<String, Operator> operators;

    public OperatorManager(){
        operators = new HashMap<String, Operator>();
    }

    public void put(String operator, Operator OperatorObj){
        operators.put(operator,OperatorObj);
    }

    public void remove(String operator){
        operators.remove(operator);
    }

    public HashMap<String, Operator> getOperators(){
        return operators;
    }


}
