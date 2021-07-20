package racing_car;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Validation validation = new Validation();
        try {
            String value[] = validation.nullCheck(input);
            validation.split(value);
            int answer = validation.validationCheck(value);
            System.out.println("사칙 연산 결과 = "+ answer);
        } catch (Exception e) {
            System.out.println(e.getMessage()+" 다시 입력 해주시기 바랍니다.");
        }
    }
}
