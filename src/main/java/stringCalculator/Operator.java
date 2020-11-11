package stringCalculator;

import java.util.ArrayList;
import java.util.HashMap;

public class Operator {

    private static ArrayList<String> symbols = new ArrayList();
    private static HashMap<String, ArithmeticInterface> operatorCollection = new HashMap<>();

    public void add(String symbol,ArithmeticInterface arithmetic){
        operatorCollection.put(symbol, arithmetic);
    }

    public static int execute(String symbol,int a, int b){
        return operatorCollection.get(symbol).operate(a,b);
    }

    public static boolean containsSymbol(String symbol) {
        return operatorCollection.containsKey(symbol);
    }

    public static void addSymbol(String symbol){
        symbols.add(symbol);
    }



}
