package racingcargame.view;

import java.util.List;

public class RacingCarGameOutputView {
    public void outputGame(List<String> history) {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
    }

    public void outputWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
