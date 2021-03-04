package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Validator validator = new Validator();

        String formula = br.readLine();

        // 입력 문자 검사
        validator.isEmptyOrIsBlank(formula);

        String[] formulaList = formula.split(" ");

        // 연산자 검사
        validator.isCheckOperation(formulaList);

        Calculate calculate = new Calculate();
        int result = calculate.calculateFormula(formulaList);
        System.out.println(result);
    }
}
