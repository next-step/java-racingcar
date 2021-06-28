package racingcargame.view;

import java.util.List;

public class RacingCarGameOutputView {
    public void outputGame(List<String> histories) {
        for (String history : histories) {
            System.out.println(history);
        }
    }

    public void outputWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
