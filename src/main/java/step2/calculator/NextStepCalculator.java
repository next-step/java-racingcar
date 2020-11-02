package step2.calculator;

import step2.calculator.domain.Operation;
import step2.calculator.domain.SymbolStack;

public class NextStepCalculator {
    public int calculate(final SymbolStack symbolStack) {
        while (symbolStack.isOperable()) {
            final int x = symbolStack.popToInt();
            final Operation op = symbolStack.popToOperation();
            final int y = symbolStack.popToInt();

            final int result = op.apply(x, y);
            saveResult(symbolStack, result);
        }

        return loadResult(symbolStack);
    }

    private void saveResult(final SymbolStack symbolStack, final int result) {
        // 중간 결과를 다시 스택에 저장
        symbolStack.add(result);
    }

    private int loadResult(final SymbolStack symbolStack) {
        // 최종 결과를 스택에서 불러오기
        return symbolStack.popToInt();
    }
}
