package race.view;

import java.util.List;

public class ResultView {

    public void printResultComment() {
        System.out.println("실행 결과\n");
    }

    public void printWinners(List<String> winners) {
        System.out.println(winners + "가 최종우승했습니다.");
    }
}
