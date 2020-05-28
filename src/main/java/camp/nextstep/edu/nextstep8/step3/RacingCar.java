package camp.nextstep.edu.nextstep8.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final static String LANE = "-";
    private final static int GO_STANDARD_VALUE = 4;
    private int number;
    private List<String> position = new ArrayList<>();

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

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public void goOrStop(int randomValue) {
        if(GO_STANDARD_VALUE < randomValue) {
            this.position.add(LANE);
        }
    }

    public void printPosition(){
        this.position.forEach(s -> System.out.print(s));
        System.out.println();
    }
}
