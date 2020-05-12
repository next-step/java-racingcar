package step2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    Queue<Integer> numQu = new LinkedList<Integer>();
    Queue<String> calQu = new LinkedList<String>();

    public boolean valCheck(String[] input) {

        for(String s : input)
        {
            if(isNumeric(s))
            {
                numQu.add(Integer.parseInt(s));
                continue;
            }

            if(!"+".equals(s) && !"-".equals(s) && !"*".equals(s) && !"/".equals(s))
            {
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
            }

            calQu.add(s);
        }

        return true;
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public int calculator(String input)
    {
        int result = 0;

        String[] splitInput = input.split(" ");
        valCheck(splitInput);
        result = numQu.poll();

        while(numQu.size() != 0)
        {
            int a = result;
            int b = numQu.poll();

            String c = calQu.poll();

            if("+".equals(c)) {
                result = (a + b);
                continue;
            }

            if("-".equals(c)) {
                result = (a - b);
                continue;
            }

            if("*".equals(c)) {
                result = (a * b);
                continue;
            }

            if("/".equals(c)) {
                if(b == 0) throw new IllegalArgumentException("0으로 나눌수 없습니다.");
                result = (a / b);
                continue;
            }
        }

        return result;
    }
}
