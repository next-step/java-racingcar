package study.racingcar.rule;

public class OutputViewRule {

    private final String carShape;
    private final String winnerDelimiter;

    public OutputViewRule() {
        this.carShape = "-";
        this.winnerDelimiter = ",";
    }

    public String getCarShape() {
        return carShape;
    }

    public String getWinnerDelimiter() {
        return winnerDelimiter;
    }
}
