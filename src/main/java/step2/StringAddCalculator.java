package step2;

public class StringAddCalculator {

    private PositiveInt positiveInt;
    private SplitStringToken splitStringToken;

    public int splitAndSum(String textInput) {
        int answer = 0;
        if (splitStringToken.isTextNotNullOrEmpty(textInput)) {
            return 0;
        }
        String[] tokens = splitStringToken.customDelimiterSplit(textInput);
        for (String token : tokens) {
            positiveInt.isPositive(answer);
            answer += positiveInt.getParseInt(token);
        }
        return answer;
    }
}
