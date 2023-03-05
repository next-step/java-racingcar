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

    // 계산기 메인
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

        for(String opt:arrOperator){
            if(result == 0) {
                result = Integer.parseInt(arrOperand.get(cnt));
            }

            result = selectFomula(result, Integer.parseInt(arrOperand.get(cnt+1)), arrOperator.get(cnt));
            cnt++;
        }

        return result;
    }

    // 연산자에 따른 공식 선택
    static int selectFomula(int operand1, int operand2, String Operator){
        int result =0;

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

    // 입력 데이터 빈칸,널값 체트
    static boolean checkInputData(String inputData){
        boolean result= false;

        if (inputData != null && !inputData.equals("")) {
            result = true;
        }

        return result;
    }

    // 입력 데이터 숫자 체크
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

    // 입력 데이터 연산자 구분
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

        // 입력 데이터 중 연산자가 아니면, exception 발생
        if(cnt == 0){
            throw new IllegalArgumentException();
        }

        return result;
    }

    // 덧셈
    static int add(int operand1, int operand2){
        int result = 0;

        result = operand1 + operand2;

        return result;
    }

    // 뺄셈
    static int sub(int operand1, int operand2){
        int result = 0;

        result = operand1 - operand2;

        return result;
    }

    // 곱셈
    static int multi(int operand1, int operand2){
        int result = 0;

        result = operand1 * operand2;

        return result;
    }

    // 나눗셈
    static int div(int operand1, int operand2){
        int result = 0;

        result = operand1 / operand2;

        return result;
    }

}
