package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarScore> getHighestCarScore() {
        int maxTravelledDistance = scoreList.stream().mapToInt(CarScore::getTravelledDistance)
                .max().orElse(0);
        return scoreList.stream()
                .filter(carScore -> carScore.isMatch(maxTravelledDistance))
                .collect(Collectors.toList());
    }

}
