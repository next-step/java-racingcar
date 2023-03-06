package calculator;

public class Calculator {
    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        try {
            return a / b;
        } catch (Exception e){
            System.out.println("can not divide zero");
        }
        return 0;
    }

    public int calculate(int firstvalue, char operator, int secondvalue){

        if(operator == '+')
            return add(firstvalue, secondvalue);

        if(operator == '-')
            return subtract(firstvalue, secondvalue);

        if(operator == '*')
            return multiply(firstvalue,secondvalue);

        if(operator == '/')
            return divide(firstvalue, secondvalue);
        throw new RuntimeException();
    }

    public String[] seperate(String str){
        return str.split(" ");
    }

    public int toInt(String str){
        return Integer.parseInt(str);
    }

    public int calculateString(String[] str){
        int result = toInt(str[0]); //미리 작성했던 메소드를 이용
        for(int i = 0; i < str.length - 2; i += 2){
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2])); //charAt 을 이용해서 String 한글자를 char로 변경
        }
        return result;
    }
}

