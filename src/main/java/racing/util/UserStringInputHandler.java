package racing.util;

import java.util.Scanner;

public class UserStringInputHandler extends UserInputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static int getUserCount(String names) {
        return split(names).length;
    }

    public static String[] split(String names){
        return names.split(",");
    }

    @Override
    public boolean validate(Object name) {
        return validate(split(String.valueOf(name)));
    }

    public boolean validate(String[] names){
        boolean result = true;
        for(String name: names){
            // 하나라도 false면 false 반환
            result = result && validate(name);
        }
        return result;
    }

    public boolean validate(String name) {
        return name != null && name != "" && validateStringLength(name);
    }

    public boolean validateStringLength(String name){
        return name.length() <= 5 && name.length() > 0;
    }
}
