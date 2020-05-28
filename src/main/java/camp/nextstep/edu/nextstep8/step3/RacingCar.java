package camp.nextstep.edu.nextstep8.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final static String LANE = "-";
    private final static int GO_STANDARD_VALUE = 4;
    private int number;
    private List<String> position = new ArrayList<>();
    private List<Integer> debugPosition = new ArrayList<>();

    public RacingCar(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getPosition() {
        return position;
    }

    public void goOrStop(int randomValue) {
        if(GO_STANDARD_VALUE < randomValue) {
            this.position.add(LANE);
        }
        debugPosition.add(randomValue);
    }

    public List<Integer> getDebugPosition() {
        return debugPosition;
    }
}
