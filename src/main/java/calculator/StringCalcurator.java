package calculator;

import com.sun.tools.javac.util.StringUtils;

public class StringCalcurator {

    public static int cal(String s) {
        if(s==null || s.equals("") || s.equals(" "))
        {
            throw new IllegalArgumentException();
        }
        String[] value = s.split(" ");
        String operator = value[1];

        if(!("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator))){
            throw new IllegalArgumentException();
        }

        if("+".equals(operator)){
            return Integer.parseInt(value[0]) + Integer.parseInt(value[2]);
        }

        if("-".equals(operator)){
            return Integer.parseInt(value[0]) - Integer.parseInt(value[2]);
        }

        if("*".equals(operator)){
            return Integer.parseInt(value[0]) * Integer.parseInt(value[2]);
        }

        return Integer.parseInt(value[0]) / Integer.parseInt(value[2]);
    }

}
