package calculator;

import java.util.Scanner;

public class Calculator {

    private String formula;

    public Calculator() {
        setFormula();
    }

    private void setFormula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해주세요: ");
        formula = scanner.nextLine();
    }

}
