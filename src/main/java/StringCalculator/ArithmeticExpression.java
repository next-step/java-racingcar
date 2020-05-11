package StringCalculator;

public class ArithmeticExpression {

    private String arithmeticExpression;

    public ArithmeticExpression(String arithmeticExpression) {
        isNotNull(arithmeticExpression);
        isPermittedLiteral(arithmeticExpression);
        isRightExpression(arithmeticExpression);
        this.arithmeticExpression = arithmeticExpression;
    }

    //연산식의 처음과 끝이 숫자 인지 체크
    private void isRightExpression(String arithmeticExpression){
        String startChar = arithmeticExpression.substring(0,1);
        String endChar = arithmeticExpression.substring(arithmeticExpression.length()-1);
        isNumber(startChar, endChar);
    }

    //해당 CharAt이 숫자 인지 체크한다.
    private void isNumber(String firstNumber, String EndNumber) {
        try {
            Integer.parseInt(firstNumber);
            Integer.parseInt(EndNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("First, End Character is Not Number");
        }
    }

    //해당 문자열이 공백이거나 null 인지 체크한다.
    private void isNotNull(String arithmeticExpression){
        if(arithmeticExpression == null || arithmeticExpression.replace(" ","").length() == 0)
            throw new  IllegalArgumentException("Expression is null");
    }

//    //연속된 연산문자, 숫자가 있는지 체크 한다.
//    private void isConsecutiveOperation(String arithmeticExpression) {
//        String [] splitArr = this.getSplitArr(arithmeticExpression);
//        for(int i=0 ; i < splitArr.length; i++) {
//
//        }
//    }

    //숫자, 연산문자 이외의 문자가 있는지 체크한다.
    private void isPermittedLiteral(String arithmeticExpression){
        ArithmeticRegex regex = new ArithmeticRegex();
        regex.isValidate(arithmeticExpression);
    }

//    private String [] getSplitArr(String arithmeticExpression) {
//        return arithmeticExpression.split("");
//    }

    @Override
    public String toString() {
        return arithmeticExpression.toString();
    }


}
