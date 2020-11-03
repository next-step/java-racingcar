package stringCalculator;

import java.util.HashMap;

public class Operator {

    static HashMap<String, ArithmeticInterface> operatorCollection = new HashMap<>();
    Symbol symbol;

    public Operator(){

    }
    public Operator(String state){
        symbol = new Symbol(state);
    }

    public void add(String symbol,ArithmeticInterface arithmetic){
        operatorCollection.put(symbol, arithmetic);
    }

    public int execute(String symbol,int a, int b){
        return operatorCollection.get(symbol).operate(a,b);

    }

}
