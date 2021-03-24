package step3.utils;

import java.util.Scanner;

public class InputValidator {
    private final static int scoreSymbolSize = 1;
    private final static int carNameSize = 5;
    private final static String seperateCarNames = ",";

    public static String validateSymbol(String symbol) {
        Scanner scan = new Scanner(System.in);
        while (symbol.getBytes().length > scoreSymbolSize) {
            System.out.println("한 바이트로 입력해주세요.");
            symbol = scan.next();
        }
        return symbol;
    }

    public static String[] validateCarName(String names) {
        String[] splited = names.split(seperateCarNames);
        for (int i = 0; i < splited.length; i++) {
            splited[i] = loopForValidateCarName(splited[i]);
        }
        return splited;
    }

    static String loopForValidateCarName(String name) {
        Scanner scan = new Scanner(System.in);
        while (isNotOkCarName(name)) {
            System.out.println(name + "의 이름을 5자 이하로 입력해주세요.");
            name = scan.next();
        }
        return name;
    }

    static boolean isNotOkCarName(String name) {
        return name.length() > carNameSize;
    }
}
