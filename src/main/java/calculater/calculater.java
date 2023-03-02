package calculater;


import java.util.Arrays;
import org.junit.Test;


public class calculater {

    static private     Integer sumData = 0;
    static private     String  operator = "+";

    static void  add(Integer val)
    {
        sumData += val;
    }
    static void  subtract(Integer val) {
        sumData -= val;
    }
    static void multiply(Integer val) {
        sumData *= val;
    }
    static void divide(Integer val){
        sumData /= val;
    }

    static void operate(String valString) {

        Integer val = 0;

        try {
            val = Integer.parseInt(valString);
        }
        catch (NumberFormatException e) {
            val = 0;
        }

        switch(operator) {
            case "+": add(val); break;
            case "-": subtract(val); break;
            case "*": multiply(val); break;
            case "/": divide(val); break;
        }
    }

    static void parseString(String data) {
        String baseString[] = data.split("[+\\-*/]", 2);

        if (0 > baseString.length)
            return;

        if (baseString.length == 1) {
            operate(baseString[0].trim());
            return;
        }
        operate(baseString[0].trim());
        operator = data.substring(baseString[0].length(), baseString[0].length()+1);
        parseString(baseString[1]);
    }

    public static void main(String[] args) {
        String input = "2+3 *4 /2";
        parseString(input);
        System.out.println(sumData.toString());
    }

}
