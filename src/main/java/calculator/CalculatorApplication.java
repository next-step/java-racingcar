package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("문자열을 공백으로 구분하여 입력하세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        ElementGenerator elementGenerator = new ElementGenerator(expression);

        System.out.println(
            new Calculator(
                elementGenerator.getNumbers(), elementGenerator.getOperators()
            ).execute()
        );
    }
}
