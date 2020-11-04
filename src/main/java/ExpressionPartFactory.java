/**
 * expression 에서 추출된 part 문자열을 입력받아 ExpressPart 객체를 생성하는 Factory
 */
public class ExpressionPartFactory {
    public ExpressionPart create(String value){
        try {
            return new Operand(Integer.parseInt(value));
        } catch (NumberFormatException e ){
            try {
                return Operator.valueOfSign(value);
            } catch ( EnumConstantNotPresentException e1 ){
                throw new RuntimeException("fail to create ExpressionPart (" + e.getMessage() + ")", e);
            }
        }
    }
}
