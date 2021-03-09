package step2.object;


import step2.exception.CheckInputException;
/**
 *<pre>
 *step2.object
 *ㄴ Calculator.java
 *</pre>
 *@date : 2021-03-10 오전 12:16
 *@authr : mugeon
 *@version : 1.0.0
 *@see
 **/
public class Calculator {

    final String BLANK = " ";

    enum Operation {
        PLUS("+") {
            public int execute(int former, int latter) {
                return former + latter;
            }
        },
        MINUS("-") {
            public int execute(int former, int latter) {
                return former - latter;
            }
        },
        MULTIPLY("*") {
            public int execute(int former, int latter) {
                return former * latter;
            }
        },
        DIVIDE("/") {
            public int execute(int former, int latter) {
                return former / latter;
            }
        };

        private final String operator;

        Operation(String operator) {
            this.operator = operator;
        }

        abstract int execute(int former, int latter);
    }

    // 1. 유효성 검사
    public boolean validate(String data){
        // 1) 입력값 빈값 체크
        if(null == data || "".equals(data)){
            throw new IllegalArgumentException();
        }

        // 2) 입력 패턴 체크
        String [] checkData = data.split(BLANK);
        if(checkData.length < 2 || checkData.length % 2 == 0){
            throw new CheckInputException();
        }

        // 3) 연산자 체크
        for(int i = 0; i<checkData.length; i++){
            boolean isOddNumber = (i % 2 == 1);
            if(isOddNumber && !validateOperator(checkData[i])){ // Operational operators
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    // 연산자 검사
    private boolean validateOperator(String operator) {
        for (Operation operation : Operation.values()) {
            if (operator.equals(operation.operator)) {
                return true;
            }
        }
        return false;
    }

    // 2. 계산
    public Integer caculation(String data){
        String [] checkData = data.split(BLANK);


        int result = Integer.parseInt(checkData[0]);
        int operatorIdx = 1;
        int operandIdx = 2;
        while(operandIdx < checkData.length){
            Operation operator = findOperatorType(checkData[operatorIdx]);
            int operand = Integer.parseInt(checkData[operandIdx]);

            result = operator.execute(result, operand);

            operatorIdx += 2;
            operandIdx += 2;
        };

        return result;
    }

    // 실행할 연산자 타입 조회
    private Operation findOperatorType(String operator){
        Operation operation;
        switch (operator){
            case "+":
                operation = Operation.PLUS;
                break;
            case "-":
                operation = Operation.MINUS;
                break;
            case "*":
                operation = Operation.MULTIPLY;
                break;
            case "/":
                operation = Operation.DIVIDE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        return operation;
    }


}
