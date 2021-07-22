package stage2.stringcalculator;

import java.util.Scanner;

public class StringInput {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        System.out.println("사용자가 입력한 문자열 : " + inputString);

        StringCalculator.calculation(inputString);
    }
}
