package step1;

import java.util.ArrayList;

public class calc {
    public static void main(String[] args) {

        //String inputData = "2 + 3 * 4 / 2";
        String inputData = "2 + 3 * 4 / 2 * 2 + 7";
        //String inputData = "2 + 3 # 4 = 2";
        //String inputData = "";

        int result = 0;

        result = Calc(inputData);

        System.out.println("["+inputData+"] 의 계산 결과는 [ "+result+" ] 입니다.");
    }

    static int Calc(String inputData){
        int result           = 0;
        int cnt              = 0;
        String[] arrInData   = {};
        ArrayList<String> arrOperand  = new ArrayList<>();
        ArrayList<String> arrOperator = new ArrayList<>();

        // 입력 데이터 체크
        if(!checkInputData(inputData)){
            throw new IllegalArgumentException();
        }

        // 입력 데이터 분리
        arrInData = inputData.split(" ");

        // 분리된 입력 데이터 구분
        for(String splitData : arrInData){
            // 숫자인지 체크
            if (isNumber(splitData)){
                arrOperand.add(splitData);
            }else if (isOperator(splitData)) {
                arrOperator.add(splitData);
            }
        }

        //System.out.println(arrOperand);
        //System.out.println(arrOperator);

        for(String opt:arrOperator){
            if(result == 0) {
                result = Integer.parseInt(arrOperand.get(cnt));
            }

            result = selectFomula(result, Integer.parseInt(arrOperand.get(cnt+1)), arrOperator.get(cnt));

            cnt++;
        }

        return result;
    }

    static int selectFomula(int operand1, int operand2, String Operator){
        int result =0;

        //System.out.println(operand1+" / "+operand2+" / "+Operator);

        if(Operator.equals("+")){
            result = add(operand1, operand2);
        }else if(Operator.equals("-")){
            result = sub(operand1, operand2);
        }else if(Operator.equals("*")){
            result = multi(operand1, operand2);
        }else if(Operator.equals("/")){
            result = div(operand1, operand2);
        }

        return result;
    }

    static boolean checkInputData(String inputData){
        boolean result= false;

        if (inputData != null && !inputData.equals("")) {
            result = true;
        }

        return result;
    }

    static boolean isNumber(String splitData){
        boolean result = false;

        try{
            Double.parseDouble(splitData);
            result = true;
        }catch (Exception e) {
            result = false;
        }

        return result;
    }

    static boolean isOperator(String splitData){
        String[] operator = {"+","-","*","/"};
        int cnt        =0;
        boolean result = false;

        for(String arrOpt : operator) {
            if(arrOpt.equals(splitData)) {
                result = true;
                cnt++;
            }
        }

        // 연산자가 아니면, exception 발생
        if(cnt == 0){
            throw new IllegalArgumentException();
        }

        return result;
    }

    static int add(int operand1, int operand2){
        int result = 0;

        result = operand1 + operand2;

        return result;
    }

    static int sub(int operand1, int operand2){
        int result = 0;

        result = operand1 - operand2;

        return result;
    }

    static int multi(int operand1, int operand2){
        int result = 0;

        result = operand1 * operand2;

        return result;
    }

    static int div(int operand1, int operand2){
        int result = 0;

        result = operand1 / operand2;

        return result;
    }

}
