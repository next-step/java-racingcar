package calculator;

import calculator.text_split.InputText;
import calculator.text_split.concrete.*;
import calculator.text_split.handler.TextSplit;

import java.util.List;

public class TextCalculator {
    public static int calculate(String input) {
        InputText inputText = new InputText(input);
        TextSplit basicSplit = new BasicSplit(inputText);
        TextSplit nullSplit = new NullSplit(inputText);
        TextSplit emptySplit = new EmptySplit(inputText);
        TextSplit customDelimiterSplit = new CustomDelimiterSplit(inputText);
        TextSplit defaultDelimiterSplit = new DefaultDelimiterSplit(inputText);
        basicSplit
                .setNext(nullSplit)
                .setNext(emptySplit)
                .setNext(customDelimiterSplit)
                .setNext(defaultDelimiterSplit);
        basicSplit.split();
        List<String> texts = inputText.getTokens();

        CalcNumbers calcNumbers = new CalcNumbers(texts);
        return new Operator(calcNumbers).sum();
    }
}
