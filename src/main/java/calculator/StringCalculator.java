package calculator;

public class StringCalculator {
    static int calculate(String text) {

        //validation
//        if(text == null || text.trim()="") return 0;

        String[] values = text.split(" ");
        int result=Integer.parseInt(values[0]);
        int count = values.length;
        int idx=1;

        while(idx < count) {
            String expression = values[idx++];
            int number = Integer.parseInt(values[idx++]);
            result = calculrate(result, number, expression);
        }

        return result;
    }


    private static int calculrate(int i, int j, String expression) {
        if("+".equals(expression)) {
            return i + j;
        }

        if("-".equals(expression)) {
            return i - j;
        }

        if("*".equals(expression)) {
            return i * j;
        }

        if("/".equals(expression)) {
            return i / j;
        }

        return 0;
    }
/*
    static int add(int i, int j) {
        return i + j;
    }

    static int subtract(int i, int j) {
        return i - j;
    }

    static int multiply(int i, int j) {
        return i * j;
    }

    static int divide(int i, int j) {
        return i / j;
    }*/
}
