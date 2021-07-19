package step1.helper;

public class SetCollectionTestArgument {
    private final int input;
    private final boolean expected;

    public SetCollectionTestArgument(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    public int getInput() {
        return input;
    }

    public boolean isExpected() {
        return expected;
    }
}
