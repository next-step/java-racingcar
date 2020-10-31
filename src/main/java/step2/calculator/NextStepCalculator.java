package step2.calculator;

public class NextStepCalculator {
    // 모든 연산은 x, y, operation symbol 이 필요함. ex) x + y
    private static final int OPERABLE_MINIMUM_SIZE = 3;

    public int calculate(final Expression ex) {
        final SymbolStack symbolStack = new SymbolStack(ex.getSymbols());

        while (isOperable(symbolStack)) {
            final int x = symbolStack.popToInt();
            final Operation op = symbolStack.popToOperation();
            final int y = symbolStack.popToInt();

            final int result = op.apply(x, y);

            saveResult(symbolStack, result);
        }

        return symbolStack.popToInt();
    }

    private void saveResult(final SymbolStack symbolStack, final int result) {
        // 중간 결과를 다시 스택에 저장
        symbolStack.add(result);
    }

    private boolean isOperable(final SymbolStack symbolStack) {
        return symbolStack.size() >= OPERABLE_MINIMUM_SIZE;
    }
}
