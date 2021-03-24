package step1;

public class Calculator {

    public Calculator(){

    }
    //더하기
    private int _sum(int a, int b) {
        return a + b;
    }

    //뺄셈
    private int _minus(int a, int b) {
        return a - b;
    }

    //곱셈
    private int _multiply(int a, int b) {
        return a * b;
    }

    //나눗셈
    private int _divide(int a, int b) {
        return (int) (a / b);
    }


    private int _changeInt(String numStr){
        return Integer.parseInt(numStr);
    }


    private int _executeExp(int num,int resultNum,String sign){

        if("+".equals(sign)){
            return _sum(resultNum,num);
        }

        if("-".equals(sign)){
            return _minus(resultNum,num);
        }

        if("*".equals(sign)){
            return _multiply(resultNum,num);
        }

        if("/".equals(sign)){
            return _divide(resultNum,num);
        }

        return -1;
    }


    private String[] _divideBlank(String expression){
        return expression.split(" ");
    }

    public int execute(String expression) {

        //빈공백을 중심으로 수식 쪼개기
        String [] dividedExpArr = _divideBlank(expression);
        int dividedExpArrSize = dividedExpArr.length;
        int resultNum = Integer.parseInt(dividedExpArr[0]);
        for(int i=1; i<dividedExpArrSize; i+=2){

            int num = Integer.parseInt(dividedExpArr[i+1]);

            String sign = dividedExpArr[i];

            resultNum = _executeExp(num,resultNum,sign);
        }
       return resultNum;
    }


    public static void main(String[] args) {
        String expression = "2 + 4 * 5";
        new Calculator().execute(expression);

    }
}
