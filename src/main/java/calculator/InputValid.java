package calculator;

public class InputValid {

    static boolean isNull(String[] inputArray) {
        return inputArray == null;
    }

    static boolean isEmpty(String[] inputArray) {
        return inputArray.length == 0;
    }

    static boolean isNotAble(String[] inputArray) {
        return inputArray.length % 2 == 0;
    }
}
