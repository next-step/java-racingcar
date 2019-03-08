package calculator;

public class StringCalculator {
    static int calculate(String text) {
        if(text == null || text.length() == 0) {
            return -1;
        }
        String[] values = text.split(" ");
        if(values.length == 0) {
            return -1;
        }
        int i = Integer.parseInt(values[0]);
        int j = Integer.parseInt(values[2]);
        String ch = values[1];

        for(int k=0; k<values.length; ) {
            if(k == 0) {
                i = Integer.parseInt(values[k]);
            }
            ch = values[k+1];
            j = Integer.parseInt(values[k+2]);
            k = k+2;
            
        }

        Integer x = calculating(ch, i, j);
        if (x != null) return x;
        return 0;
    }

    private static Integer calculating(String ch, int i, int j) {
        if(ch.equals("+")) {
            return i + j;
        }
        if(ch.equals("*")) {
            return i * j;
        }
        if(ch.equals("-")) {
            return i - j;
        }
        if(ch.equals("/")) {
            return i / j;
        }
        return null;
    }
}
