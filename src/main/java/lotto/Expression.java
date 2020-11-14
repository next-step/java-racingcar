package lotto;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private final DelimiterList delimiterList;
    private final OperandList operandList;

    public Expression(String expression) {
        this.delimiterList = new DelimiterList();
        RawExpression rawExpression = new RawExpression(expression);
        this.delimiterList.addCustomDelimiter(
                rawExpression.refineCustomDelimiter()
        );
        List<String> splitResult = Arrays.asList(
                rawExpression
                        .refineRawExpression()
                        .split(delimiterList.toSplitRegex()
                        )
        );
        this.operandList = new OperandList(splitResult);
    }

    public Integer sum() {
        return this.operandList.sum();
    }
}
