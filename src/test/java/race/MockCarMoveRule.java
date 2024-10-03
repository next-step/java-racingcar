package race;

class MockCarMoveRule implements ICarMoveRule {
    private final boolean checkResult;

    private MockCarMoveRule(boolean checkResult) {
        this.checkResult = checkResult;
    }

    public boolean check() {
        return checkResult;
    }

    public static MockCarMoveRule createThatPassed() {
        return new MockCarMoveRule(true);
    }

    public static MockCarMoveRule createThatFailed() {
        return new MockCarMoveRule(false);
    }
}
