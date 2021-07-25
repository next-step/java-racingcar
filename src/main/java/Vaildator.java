public class Vaildator {
    public static final String EMPTY = " ";

    public static void vaildateInit(String expression) {
        if(expression.equals(EMPTY) || expression == null) {
            throw new IllegalArgumentException("문자열이 비어있습니다.");
        }
        String[] splitStr = expression.split(EMPTY);
        if(!Util.isNumeric(splitStr[0])) {
            throw new IllegalArgumentException("첫번째 문자열은 숫자이어야 합니다.");
        }
    }
}
