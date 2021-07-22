package stringcalculator.util;

import java.util.Scanner;

public class UserInputUtils {

    public static final String WHITE_SPACE_STRING = " ";


    public static String readUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("처리할 연산을 공백을 포함해 입력하시오.(예: 1 + 1) :");
        String userInput = sc.nextLine();
        sc.close();

        validate(userInput);

        return userInput;
    }

    public static String[] splitUserInput(String userInput) {
        return userInput.split(WHITE_SPACE_STRING);
    }

    protected static void validate(String str) {
        checkNullString(str);
        checkEmptyString(str);
    }

    private static void checkEmptyString(String str) {
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("공백문자만으로는 연산을 수행할 수 없습니다.");
        }
    }

    private static void checkNullString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("유저로부터 입력이 전혀 없습니다.");
        }
    }


}
