package step2.operation;

public class PlusOperation implements ArithmeticOperation {
    @Override
    public Integer apply(Integer value1, Integer value2) {
        return value1 + value2;
    }
}
