package calculator;

import calculator.textsplit.InputText;
import calculator.textsplit.concrete.CustomDelimiterSplit;
import calculator.textsplit.concrete.DefaultDelimiterSplit;
import calculator.textsplit.concrete.EmptySplit;
import calculator.textsplit.concrete.NoSplit;
import calculator.textsplit.handler.TextSplit;

public class TextCalculator {
    public static int calculate(String input) {
        InputText inputText = new InputText(input);

        TextSplit basicSplit = new NoSplit(inputText);
        TextSplit emptySplit = new EmptySplit(inputText);
        TextSplit customDelimiterSplit = new CustomDelimiterSplit(inputText);
        TextSplit defaultDelimiterSplit = new DefaultDelimiterSplit(inputText);
        basicSplit
                .setNext(emptySplit)
                .setNext(customDelimiterSplit)
                .setNext(defaultDelimiterSplit);
        basicSplit.split();

        CalcNumbers calcNumbers = new CalcNumbers(inputText.getTokens());
        return new Operator(calcNumbers).sum();
    }
}
