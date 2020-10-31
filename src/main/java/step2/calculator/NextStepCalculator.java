package step2.calculator;

import step2.calculator.domain.Expression;
import step2.calculator.domain.Operation;
import step2.calculator.domain.SymbolStack;

public class NextStepCalculator {
    public int calculate(final Expression ex) {
        final SymbolStack symbolStack = new SymbolStack(ex.getSymbols());

        while (symbolStack.isOperable()) {
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
}
