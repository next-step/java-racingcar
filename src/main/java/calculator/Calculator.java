package calculator;

import calculator.domain.Operator;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private List<Integer> numbers;
    private List<Operator> operators;
    private Parser parser;

    private int total;

    public Calculator() {
        this.total = 0;

        setFormula();

        this.numbers = parser.getNumbers();
        this.operators = parser.getOperators();
        
        calculate();
    }

    public Calculator(String formula) {
        parser = new Parser(formula);

        this.numbers = parser.getNumbers();
        this.operators = parser.getOperators();

        calculate();
    }

    private void setFormula() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("수식을 입력해주세요: ");
        parser = new Parser(scanner.nextLine());
    }

    private void calculate() {
        int index = 0;

        total = numbers.get(index);
        for (Operator operator: operators) {
            total = operator.calculate(total, numbers.get(index + 1));
            index++;
        }

    }

    public int value() {
        return this.total;
    }
}
