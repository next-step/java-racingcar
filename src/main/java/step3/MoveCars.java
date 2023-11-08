package step3;

public class MoveCars {
    private final int turnCount;
    private final int decisionValue;

    public MoveCars(int turnCount, int decisionValue) {
        this.turnCount = turnCount;
        this.decisionValue = decisionValue;
    }

    public void process(MoveCarStatus moveCarStatus, ResultView resultView) {
        for (int i = 0; i < turnCount; i++) {
            moveCarStatus.getResultMap().forEach((key, value) -> {
                int randomValue = (int) (Math.random() * 10);
                if (randomValue >= decisionValue) {
                    moveCarStatus.getResultMap().put(key, value + 1);
                }
            });
            resultView.printResult('*');
        }
    }

}
