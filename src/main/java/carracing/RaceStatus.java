package carracing;

import java.util.List;
import java.util.stream.Collectors;

public class RaceStatus {
    private static final String HYPHEN = "-";
    private static final String NEXT_LINE = "\n";

    private final List<Integer> positionOfCarList;
    private final boolean isLastAttempt;

    public RaceStatus(List<Integer> positionOfCarList, boolean isLastAttempt) {
        this.positionOfCarList = positionOfCarList;
        this.isLastAttempt = isLastAttempt;
    }

    public String hyphenExpression() {
        StringBuilder hyphenExpressionBuilder = new StringBuilder();

        String defaultHyphenExpression = positionOfCarList.stream()
                .map(HYPHEN::repeat)
                .collect(Collectors.joining(NEXT_LINE));

        hyphenExpressionBuilder.append(defaultHyphenExpression);

        if(!isLastAttempt) {
            hyphenExpressionBuilder.append(NEXT_LINE);
        }

        return hyphenExpressionBuilder.toString();
    }
}
