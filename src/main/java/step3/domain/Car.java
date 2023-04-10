package step3.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private String distance = "";

    public String tryMove(int randomValue) {
        if (randomValue < MOVE_CONDITION) {
            return distance;
        }
        return distance += "-";
    }
}
