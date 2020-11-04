/**
 * expression 을 구성하는 단위
 * expression 은 whitespace 로 구분되어 있습니다. 구분된 연속된 문자열이 expression part 입니다.
 */
public interface ExpressionPart{

    enum Type {
        Operand, Operator
    }

    Type type();
}
