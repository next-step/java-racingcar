package StringCal;

import org.jetbrains.annotations.NotNull;

public class StringCal {

    public int calculateString(String @NotNull [] str){
        int result = toInt(str[0]);
        for(int i = 0; i < str.length - 2; i += 2){
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));
        }
        return result;
    }

    public int toInt(String str){
        return Integer.parseInt(str);
    }

    public String[] seperate(String str){
        return str.split(" ");
    }

    public int calculate(int x, char oper, int y){

            if(oper == '+')
                return add(x, y);

            if(oper == '-')
                return subtract(x, y);

            if(oper == '*')
                return multiply(x, y);

            if(oper == '/')
                return divide(x, y);
            else System.out.println("잘못된 값 입력");
            throw new RuntimeException();
        }

    public int subtract(int x, int y)
        {
            return x-y;
        }


    public int add(int x, int y)
    {
        return x+y;
    }


    public int multiply(int x, int y)
    {
        return x*y;
    }

    public int divide(int x, int y)
    {
        try{
            return x / y;
        } catch (Exception e){
            System.out.println("0으로 나눌 수 없습니다!");
        }
        return x / y;
    }



}
