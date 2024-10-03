package racing;

public class RacingCar {

    private int totalForwardCounts;
    private Operator operator;

    public RacingCar(Operator operator) {
        this.totalForwardCounts = 0;
        this.operator = operator;
    }

    public void race() {
        if (operator.isOngoing()) {
            this.totalForwardCounts += 1;
        }
    }

    public int getTotalForwardCounts() {
        return this.totalForwardCounts;
    }
}
