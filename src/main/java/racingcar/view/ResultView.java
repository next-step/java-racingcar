package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class ResultView {
    private static final String HYPHEN_SIGN = "-";

    public void racingShow(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(draw(racingCar));
        }
        System.out.println();
    }

    public String draw(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < racingCar.getMoveCount(); i ++) {
            sb.append(HYPHEN_SIGN);
        }

        return sb.toString();
    }
}
