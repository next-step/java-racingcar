package racingcar;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static void main(String[] args) {
        int carCount = new InputView().getCount("자동차 대수는 몇 대 인가요?");
        int moveCount = new InputView().getCount("시도할 회수는 몇 회 인가요?");
        ResultView resultView = new ResultView();

        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            racingCarList.add(new RacingCar());
        }

        for (int i = 0; i < moveCount; i++) {
            for (RacingCar racingCar : racingCarList) {
                racingCar.goOrStopRacing(new Random().nextInt(10));
            }

            resultView.racingShow(racingCarList);
        }


    }
}
