package step2;

public class ParserFactory {

    private static final Parser<Integer> integerParser = new IntegerParser();
    private static final Parser<Operator> operatorParser = new OperatorParser();

    @SuppressWarnings("unchecked")
    public static <T> Parser<T> getParser(Class<T> type) {
        if (Integer.class.equals(type)) {
            return (Parser<T>) integerParser;
        }
        if (Operator.class.equals(type)) {
            return (Parser<T>) operatorParser;
        }
        throw new IllegalArgumentException("지원하지 않는 타입입니다.");
    }
}
