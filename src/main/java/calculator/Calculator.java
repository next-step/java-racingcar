package calculator;

import calculator.domain.Numbers;
import calculator.domain.Parser;
import calculator.domain.operator.Operator;
import calculator.domain.operator.Operators;
import java.util.Scanner;

public class Calculator {

    private final Numbers numbers;
    private final Operators operators;
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

        total = numbers.get(index).value();
        for (Operator operator : operators.get()) {
            total = operator.calculate(total, numbers.get(index + 1).value());
            index++;
        }

    }

    public int value() {
        return this.total;
    }
}
