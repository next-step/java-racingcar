package calculator;

import calculator.text_split.InputText;
import calculator.text_split.concrete.*;
import calculator.text_split.handler.TextSplit;

import java.util.List;

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
