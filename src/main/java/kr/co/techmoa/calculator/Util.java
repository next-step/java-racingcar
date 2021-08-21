package kr.co.techmoa.calculator;

public class Util {

    public static boolean isNumeric(String string) {
        return string.matches("-?\\d+(\\.\\d+)?");
    }

}
