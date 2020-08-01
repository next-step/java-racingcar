package calculator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {
    private int result;

    public Calculator(String inputText) {
        String[] arrSplitText = inputText.split(" ");
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger total = new AtomicInteger(0);

        if ("".equals(inputText) || inputText == null) {
            throw new IllegalArgumentException(ErrorMsg.IS_NULL_OR_BLANK.msg);
        }

        Arrays.stream(arrSplitText).forEach(s -> {
            if (!isNumber(s)) {
                if (!isOperationSymbol(s)) {
                    throw new IllegalArgumentException(s.concat(" : " + ErrorMsg.NOT_OPERATION_SYMBOL.msg));
                }
                Arrays.stream(Operator.values()).forEach(operator -> {
                    Operator op = Operator.valueOf(operator.name());
                    if (s.equals(op.valueOf(operator.name()).getName())) {
                        total.set(op.calculate(total.get() == 0 ? arrSplitText[i.get() - 1] : total.toString(), arrSplitText[i.get() + 1]));
                    }
                });
            }
            i.getAndIncrement();
        });
        setResult(total.get());
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOperationSymbol(String text) {
        AtomicBoolean inOperator = new AtomicBoolean(false);
        Arrays.stream(Operator.values()).forEach(operator -> {
            if (operator.getName().equals(text)) inOperator.set(true);
        });
        return inOperator.get();
    }
}
