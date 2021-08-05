package step2;

public class Calculator {

    public int calculate(String formula) {

        checkInput(formula);

        return calculate(formula.split(" "));
    }

    private void checkInput(String formula) {
        if(formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("input 값이 없습니다.");
        }
    }

    private int calculate(String[] terms) {

        int current = Integer.parseInt(terms[0]); // 왼쪽 항

        for(int i = 1; i < terms.length; i +=2) {
            current = Operator.calculate(terms[i], current, Integer.parseInt(terms[i + 1]));
        }

        return current;
    }

}
