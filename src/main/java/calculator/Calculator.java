package calculator;
import java.util.Scanner;

public class Calculator {

    private static String[] test;
    private static float result = 0;
    private static char op = ' ';
    private static int this_count = 0;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s_input = in.nextLine();
        test = s_input.split(" ");

        func(0);
        System.out.println(result);

    }

    static int func(int index)
    {
        float now;
        int ret = 0;
        this_count++;
        if (index >= test.length)
            return -1;
        try{
            now = Float.parseFloat(test[index]);
            switch(op)
            {
                case '+':
                    add(now);
                    break;
                case '-':
                    sub(now);
                    break;
                case '*':
                    mul(now);
                    break;
                case '/':
                    div(now);
                    break;
                default:
                    result = now;
                    break;
            }
            index++;
            ret = func(index);
        }
        catch (NumberFormatException ex) {
            op = test[index].charAt(0);
            index++;
            ret = func(index);
        }
        return ret;
    }

    static void add(float a)
    {
        result += a;
        op = ' ';
    }
    static void sub (float a)
    {
        result -= a;
        op = ' ';
    }
    static void mul (float a)
    {
        result*=a;
        op = ' ';
    }
    static void div (float a)
    {
        if(a == 0)
        {
            op = ' ';
            return;
        }
        result /= a;
        op = ' ';
    }
}
