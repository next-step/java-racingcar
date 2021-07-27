package racingCar.utils;

public class StringUtil {
    private StringUtil(){}
    public static String[] divideByComma(String inputName) {
        return inputName.split(",");
    }
}
