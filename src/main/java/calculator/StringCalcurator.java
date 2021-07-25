package calculator;

public class StringCalcurator {

    public static int cal(String s) {
        String[] value = s.split(" ");
        String operator = value[1];

        if("+".equals(operator)){
            return Integer.parseInt(value[0]) + Integer.parseInt(value[2]);
        }

        return Integer.parseInt(value[0]) - Integer.parseInt(value[2]);
    }

}
