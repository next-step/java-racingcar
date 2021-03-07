import java.util.ArrayList;

public class Calcurator {


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
            return _sum(num,resultNum);
        }

        if("-".equals(sign)){
            return _minus(num,resultNum);
        }

        if("*".equals(sign)){
            return _multiply(num,resultNum);
        }

        if("/".equals(sign)){
            return _divide(num,resultNum);
        }

        return -1;
    }


    private String[] _divideBlank(String expression){
        return expression.split(" ");
    }

    void execute(String expression) {

        //빈공백을 중심으로 수식 쪼개기
        String [] dividedExpArr = _divideBlank(expression);
        int dividedExpArrSize = dividedExpArr.length;
        int resultNum = Integer.parseInt(dividedExpArr[0]);
        for(int i=0; i<dividedExpArrSize; i+=3){

            //int num =

            int num = Integer.parseInt(dividedExpArr[i+2]);

            String sign = dividedExpArr[i+1];

            resultNum +=_executeExp(num,resultNum,sign);

        }


        System.out.println("resultNum == " + resultNum);

    }


    public static void main(String[] args) {
        String expression = "2 + 4 * 5";
        new Calcurator().execute(expression);

    }
}
