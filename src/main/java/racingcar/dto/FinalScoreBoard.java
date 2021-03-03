package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class FinalScoreBoard {

    private List<ScoreBoardPerPlay> scoreList = new ArrayList<>();

    public List<ScoreBoardPerPlay> getAllScore (){
        return scoreList;
    }
    public void add(int playCountNumber,List<CarScore> carScoreList){
        scoreList.add(new ScoreBoardPerPlay(playCountNumber,carScoreList));
    }
}
