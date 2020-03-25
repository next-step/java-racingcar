package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int position;
    private String carName;
    private List<Round> roundInformations = new ArrayList<Round>();

    public Car(String carName) {
        this.position = 0;
        this.carName = carName;
    }

    public void move(int presentRoundTime, boolean canMove) {
        if(canMove) {
            this.position++;
        }
        completeRound(presentRoundTime);
    }

    public void completeRound(int roundTime) {
        Round round = new Round();

        round.setPosition(this.position);
        round.setTime(roundTime);

        this.roundInformations.add(round);
    }

    public List<Round> getRoundInfoList() {
        return this.roundInformations;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
