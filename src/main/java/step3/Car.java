package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private int position = 0;
    private List<Round> roundInfoList = new ArrayList<Round>();

    public void move(int roundTime) {
        Round round = new Round();

        this.position++;
        round.setPosition(this.position);

        round.setTime(roundTime);

        this.roundInfoList.add(round);
    }

    public List<Round> getRoundInfoList() {
        return this.roundInfoList;
    }
}
