package calculator;

public class TokenSequence {

    private int index = 0;

    public boolean shouldOperand() {
        return index % 2 == 0;
    }

    public boolean shouldOperator() {
        return index % 2 == 1;
    }

    public void next() {
        index += 1;
    }

}
