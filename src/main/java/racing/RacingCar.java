package racing;

public class RacingCar {

    private String name;
    private int totalForwardCounts;
    private final Operator operator;

    public RacingCar(Operator operator) {
        this.totalForwardCounts = 0;
        this.operator = operator;
    }

    public RacingCar(String name, Operator operator) {
        this.name = name;
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

    public String getName() {
        return this.name;
    }
}
