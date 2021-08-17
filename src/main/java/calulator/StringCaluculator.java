package calulator;

public class StringCaluculator {

    public int calculate(String s) {
        //"1+2"
        String[] input = s.split("");
        if ("+".equals(input[1])) {
            return Integer.parseInt(input[0]) + Integer.parseInt(input[2]);
        }
        if ("-".equals(input[1])) {
            return Integer.parseInt(input[0]) - Integer.parseInt(input[2]);
        }
        if ("*".equals(input[1])) {
            return Integer.parseInt(input[0]) * Integer.parseInt(input[2]);
        }
        if ("/".equals(input[1])) {
            return Integer.parseInt(input[0]) / Integer.parseInt(input[2]);
        }
        return 3;
    }

}
