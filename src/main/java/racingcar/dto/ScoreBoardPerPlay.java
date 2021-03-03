package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardPerPlay {

    private int playNumber;

    private List<CarScore> scoreList = new ArrayList<>();

    public ScoreBoardPerPlay(int playNumber, List<CarScore> scoreList) {
        this.playNumber = playNumber;
        this.scoreList = scoreList;
    }

    public int getPlayNumber() {
        return playNumber;
    }

    public List<CarScore> getScoreList() {
        return scoreList;
    }

}
