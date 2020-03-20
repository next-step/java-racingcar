package stringCalculator;

import java.util.ArrayList;
import java.util.List;


public class Formula {

    private ArrayList<String> formula;

    public Formula(List<String> formula) {
        this.formula = new ArrayList<>(formula);
        illegalFormulaException();
        illegalCalculateException();
    }

    public void illegalFormulaException() {
        if(formula.size() != 3) throw new IllegalArgumentException();
    }

    public void illegalCalculateException() {
        if(formula.get(1).equals("/") && formula.get(2).equals("0")) throw new IllegalArgumentException();
    }

    public double calculate() {
        return operate().calc(Double.parseDouble(formula.get(0)), Double.parseDouble(formula.get(2)));
    }

    public Operation operate() {

        switch (formula.get(1)) {
            case "+" :
                return Operation.PLUS;
            case "-" :
                return Operation.MINUS;
            case "*" :
                return Operation.MULTIPLY;
            case "/" :
                return Operation.DIVIDE;
            default:
                throw new IllegalArgumentException();
        }
    }


}
