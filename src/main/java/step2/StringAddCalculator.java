package step2;

public class StringAddCalculator {

    private TypeOperator typeOperator;
    private SplitStringToken splitStringToken;

    public int splitAndSum(String textInput) {
        int answer = 0;
        if (splitStringToken.isTextNotNullOrEmpty(textInput)) {
            return 0;
        }
        String[] tokens = splitStringToken.customDelimiterSplit(textInput);
        for (String token : tokens) {
            typeOperator.isPositive(answer);
            answer += typeOperator.getParseInt(token);
        }
        return answer;
    }
}
