package study.racingcar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rounds {

    private List<Round> roundList;
    private Rounds(List<Round> roundList) {
        this.roundList = new ArrayList<>(roundList);
    }

    public static Rounds from(List<Round> roundList){
        return new Rounds(roundList);
    }

    public int numberOfRound() {
        return roundList.size();
    }
}
