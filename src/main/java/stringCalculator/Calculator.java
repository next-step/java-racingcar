package stringCalculator;

import java.util.ArrayList;

public class Calculator {

    ArrayList<String> inputStringList;

    public Calculator(String input) {
        InputStringHandler inputStringHandler = new InputStringHandler();
        this.inputStringList = inputStringHandler.work(input);

    }

    public Double work() {

        while (inputStringList.size() >= 3) {
            this.inputStringList = assembleFormula();
        }
        return Double.parseDouble(this.inputStringList.get(0));
    }

    public ArrayList<String> assembleFormula() {
        Formula formula = new Formula(inputStringList.subList(0, 3));
        String result = String.valueOf(formula.calculate());

        ArrayList<String> calculatedList = new ArrayList<>(inputStringList.subList(3, inputStringList.size()));
        calculatedList.add(0, result);

        return calculatedList;
    }

}
