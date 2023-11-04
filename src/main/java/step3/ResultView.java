package step3;

import java.util.Map;
import java.util.Set;

public class ResultView {

    public void printRacingStatus(Map<Integer, Integer> racingBoard) {

        for (Integer integer : racingBoard.keySet()) {
            System.out.println(integer + " : " + "-".repeat(racingBoard.get(integer)));
        }
    }

}
