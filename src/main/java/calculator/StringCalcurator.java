package calculator;

public class StringCalcurator {

    public static int cal(String s) {
        String[] value = s.split(" ");
        return Integer.parseInt(value[0]) + Integer.parseInt(value[2]);
    }

}
