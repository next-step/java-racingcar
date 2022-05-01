package racingcarwinnerrefactor.view;

import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.WinnerCars;

public class ResultView {
    public static void init() {
        System.out.println("실행 결과");
    }

    public static void printCurrentResult(ParticipatedCars participatedCars) {
        System.out.println(participatedCars);
    }

    public static void printWinnerResult(WinnerCars winnerCars) {
        System.out.println(winnerCars + "가 최종 우승했습니다.");
    }
}
