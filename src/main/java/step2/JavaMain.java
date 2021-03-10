package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();

        // 입력 문자 검사
        try {
            Validator.isEmptyOrIsBlankOrIsNull(formula);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        String[] formulaList = formula.split(" ");
        try {
            Validator.isCheckOperation(formulaList);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Calculate calculate = new Calculate();
        int result = calculate.calculateFormula(formulaList);
        System.out.println(result);

        br.close();
    }
}
