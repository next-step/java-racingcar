package racing.view;

import java.util.List;
import java.util.StringJoiner;

import racing.model.RacingCar;

public class ResultView {

    public ResultView() {
        System.out.println("\n실행 결과");
    }

    public void turnResultView(List<RacingCar> movedCarList) {
        for (int i = 0; i < movedCarList.size(); i++) {
            RacingCar racingCar = movedCarList.get(i);
            System.out.print(movedCarList.get(i).getRacingCarName() + " : ");
            drawPosition(racingCar);
            System.out.println();
        }
        System.out.println();
    }

    public void drawPosition(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void drawWinner(List<RacingCar> winners) {
        StringJoiner winner = new StringJoiner(",");
        for (RacingCar racingCar : winners) {
            winner.add(racingCar.getRacingCarName());
        }
        System.out.println(winner.toString() + "가 최종 우승했습니다.");
    }
}

