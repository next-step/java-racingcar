package calculator;

import java.util.Arrays;

public class Calculator {
    public Calculator(String cmd) {
        String[] cmdAry = cmd.split(" ");
        int res = Integer.parseInt(cmdAry[0]);

        for (int i = 1; i < cmdAry.length; i+=2) {
            if (cmdAry[i].equals("+")) {
                res += Integer.parseInt(cmdAry[i+1]);
            } else if (cmdAry[i].equals("-")) {
                res -= Integer.parseInt(cmdAry[i+1]);
            } else if (cmdAry[i].equals("*")) {
                res *= Integer.parseInt(cmdAry[i+1]);
            } else if (cmdAry[i].equals("/")) {
                res /= Integer.parseInt(cmdAry[i+1]);
            }
        }
        System.out.println(res);
    }
}


