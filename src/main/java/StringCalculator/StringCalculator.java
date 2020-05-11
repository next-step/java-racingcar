package StringCalculator;

public class StringCalculator {

    //주어진 문자열을 계산한다.
    public double calculate(ArithmeticExpression arithmeticExpression){

        double preNumber = 0;
        double nextNumber = 0;
        double sum = 0;
        OperationRegex operationRegex = new OperationRegex();

        String [] expressionArr = this.splitString(arithmeticExpression.toString());
        preNumber = Double.parseDouble(expressionArr[0]);

        for(int i=0 ; i < expressionArr.length ; i++) {
            //연산 문자의 경우
            if(operationRegex.isValidate(expressionArr[i])){
                //연산
                nextNumber = Double.parseDouble(expressionArr[i+1]);
                sum = operate(preNumber, expressionArr[i], nextNumber);
                preNumber = sum;
                continue;
            }
        }
        return sum;
    }

    public String [] splitString(String arithmeticExpression) {
        return arithmeticExpression.split(" ");
    }

    private double operate(double preNumber, String operation, double nextNumber) {
        double operationValue = 0;
        switch (operation) {
            case "+" :
                operationValue = plusOperation(preNumber, nextNumber);
                break;
            case "-" :
                operationValue = minusOperation(preNumber, nextNumber);
                break;
            case "*" :
                operationValue = multiplyOperation(preNumber, nextNumber);
                break;
            case "/" :
                operationValue = divisionOperation(preNumber, nextNumber);
                break;
        }
        return operationValue;
    }

    //더하기 연산
    private double plusOperation(double preNumber, double nextNumber){
        return preNumber + nextNumber;
    }

    //빼기 연산
    private double minusOperation(double preNumber, double nextNumber){
        return preNumber - nextNumber;
    }

    //곱하기 연산
    private double multiplyOperation(double preNumber, double nextNumber){
        return preNumber * nextNumber;
    }

    //나누기 연산
    private double divisionOperation(double preNumber, double nextNumber){
        return preNumber / nextNumber;
    }



}
