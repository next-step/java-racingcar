package step2;

/**
 * expression 에서 추출된 part 문자열을 입력받아 ExpressPart 객체를 생성하는 Factory
 */
public class ExpressionPartFactory {
    public ExpressionPart create(String value){

        if( isNumeric(value) ) {
            return new Operand(Integer.parseInt(value));
        }
        if( isOperator(value) ){
            return Operator.valueOfSign(value);
        }
        throw new RuntimeException("fail to create step2.ExpressionPart ( " + value + " )");
    }

    private boolean isOperator(String value) {
        try{
            Operator.valueOfSign(value);
            return true;
        } catch ( EnumConstantNotPresentException e ) {
            return false;
        }
    }

    private boolean isNumeric(String value) {
        try{
            Integer.parseInt(value);
            return true;
        } catch ( NumberFormatException e ){
            return false;
        }
    }
}
