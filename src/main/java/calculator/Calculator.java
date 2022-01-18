package calculator;

import calculator.domain.Operator;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private Parser parser;

    private List<Integer> numbers;
    private List<Operator> operators;

    public Calculator() {
        setFormula();

        this.numbers = parser.getNumbers();
        this.operators = parser.getOperators();

        calculate();
    }

    // Test
    public Calculator(String formula) {
        parser = new Parser(formula);
    }

    private void setFormula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해주세요: ");
        parser = new Parser(scanner.nextLine());
    }

    private void calculate() {

    }
}
