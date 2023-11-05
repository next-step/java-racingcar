package calculator;

import calculator.text_split.InputText;
import calculator.text_split.concrete.CustomDelimiterSplit;
import calculator.text_split.concrete.DefaultDelimiterSplit;
import calculator.text_split.concrete.EmptySplit;
import calculator.text_split.concrete.NoSplit;
import calculator.text_split.handler.TextSplit;

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
