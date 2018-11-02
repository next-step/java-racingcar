package calculator;

public class StringCalculator {
    public static int calculaor(String text) {
        String[] values = text.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length ; i++) {

            if ("+-*/".contains(values[i])) {

                int nextNum = Integer.parseInt(values[i + 1]);

                if (values[i].equals("+")) {
                    result = result + nextNum;
                }
                if(values[i].equals("-")) {
                    result =  result - nextNum;
                }
                if(values[i].equals("/")) {
                    result =  result / nextNum;
                }
                if(values[i].equals("*")) {
                    result = result * nextNum;
                }
            }

        }
        return result;




    }
}
