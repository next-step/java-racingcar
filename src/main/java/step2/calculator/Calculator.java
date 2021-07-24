package step2.calculator;

public class Calculator {
    String cmd;
    public Calculator(String cmd) {
        this.cmd = cmd;
    }
    public void calc(){
        String[] cmdAry = cmd.split(" ");
        int res = Integer.parseInt(cmdAry[0]);

        for (int i = 1; i < cmdAry.length; i+=2) {
            if (cmdAry[i].equals("+")) {
                res = plus(res, Integer.parseInt(cmdAry[i+1]));
            } else if (cmdAry[i].equals("-")) {
                res = minus(res, Integer.parseInt(cmdAry[i+1]));
            } else if (cmdAry[i].equals("*")) {
                res = multi(res, Integer.parseInt(cmdAry[i+1]));
            } else if (cmdAry[i].equals("/")) {
                res = divide(res, Integer.parseInt(cmdAry[i+1]));
            }
        }
        System.out.println(res);
    }

    public Integer plus(int a, int b){
        return a+b;
    }
    public Integer minus(int a, int b){
        return a-b;
    }
    public Integer multi(int a, int b){
        return a*b;
    }
    public Integer divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a/b;
    }
}


