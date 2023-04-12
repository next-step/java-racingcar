package step2;

public class StringAddCalculator {

    public static int splitAndSum(String textInput) {
        int answer = 0;
        if (SplitStringToken.isTextNotNullOrEmpty(textInput))
            return 0;
        String[] tokens = SplitStringToken.customDelimiterSplit(textInput);
        for (String token : tokens) {
            TypeOperator.isPositive(answer);
            answer += TypeOperator.getParseInt(token);
        }
        return answer;
    }
}
