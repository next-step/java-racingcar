package stringcalculator.util;

import java.util.Scanner;

public class UserInputUtils {

    public static String readUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("처리할 연산을 공백을 포함해 입력하시오.(예: 1 + 1) :");
        String userInput = sc.nextLine();
        sc.close();

        return userInput;
    }
}
