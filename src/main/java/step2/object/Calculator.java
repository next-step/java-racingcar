package step2.object;


import step2.exception.BizException;

public class Calculator {

    final String BLANK = " ";

    enum Operation {
        plus("+") {
            public int execute(int former, int latter) {
                return former + latter;
            }
        },
        minus("-") {
            public int execute(int former, int latter) {
                return former - latter;
            }
        },
        multiply("*") {
            public int execute(int former, int latter) {
                return former * latter;
            }
        },
        divide("/") {
            public int execute(int former, int latter) {
                return former / latter;
            }
        };

        // 연산자 검사
        private static boolean validateOperator(String operator) {
            for (Operation operation : values()) {
                if (operator.equals(operation.operator)) {
                    return true;
                }
            }
            return false;
        }

        private final String operator;

        Operation(String operator) {
            this.operator = operator;
        }

        abstract int execute(int former, int latter);
    }

    // 1. 유효성 검사
    public boolean validate(String data){
        // 1) 입력값 빈값 체크
        if(null == data || "".equals(data))
            throw new IllegalArgumentException();

        // 2) 입력 패턴 체크
        String [] checkData = data.split(BLANK);
        if(checkData.length < 2 || checkData.length % 2 == 0)
            throw new BizException("Please enter it correctly");

        // 3) 연산자 체크
        for(int i = 0; i<checkData.length; i++){
            boolean isOddNumber = (i % 2 == 1);
            if(isOddNumber && !Operation.validateOperator(checkData[i])){ // Operational operators
                throw new IllegalArgumentException();
            }
        }
        return true;
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
    public Operation findOperatorType(String operator){
        Operation operation;
        switch (operator){
            case "+":
                operation = Operation.plus;
                break;
            case "-":
                operation = Operation.minus;
                break;
            case "*":
                operation = Operation.multiply;
                break;
            case "/":
                operation = Operation.divide;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        return operation;
    }


}
