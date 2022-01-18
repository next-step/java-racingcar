package calculator;

import calculator.domain.Expression;
import calculator.domain.Validator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String expression = br.readLine();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        while (!Validator.checkValidate(str)) {
            System.out.println(str);
            str = scanner.nextLine();
        }
        // d
        // 유효성 검사 -> 통과하면 Expression 에 넣어서 계산 처리
    }

}
