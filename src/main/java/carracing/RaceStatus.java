package carracing;

import java.util.List;

public class RaceStatus {
    private static final String HYPHEN = "-";
    private static final String NEXT_LINE = "\n";

    private final List<Integer> positionOfCarList;

    public RaceStatus(List<Integer> positionOfCarList) {
        this.positionOfCarList = positionOfCarList;
    }

    public String hyphenExpression() {
        StringBuilder hyphenExpressionBuilder = new StringBuilder();

        positionOfCarList.forEach(positionOfCar ->
                hyphenExpressionBuilder
                        .append(HYPHEN.repeat(positionOfCar))
                        .append(NEXT_LINE)
        );

        return hyphenExpressionBuilder.toString();
    }
}
