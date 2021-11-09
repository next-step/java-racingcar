package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void racingShow(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(draw(racingCar));
        }
        System.out.println();
    }

    public String draw(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < racingCar.getMoveCount(); i ++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
