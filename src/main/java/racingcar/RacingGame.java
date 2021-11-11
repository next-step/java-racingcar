package racingcar;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final String NUMBER_OF_CAR_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_TRY_MSG = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        InputView carInputView = new InputView(NUMBER_OF_CAR_MSG);
        InputView tryInputView = new InputView(NUMBER_OF_TRY_MSG);
        ResultView resultView = new ResultView();
        System.out.println();
        System.out.println("실행 결과");

        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carInputView.getCount(); i++) {
            racingCarList.add(new RacingCar());
        }

        for (int i = 0; i < tryInputView.getCount(); i++) {
            for (RacingCar racingCar : racingCarList) {
                racingCar.goOrStopRacing(new Random().nextInt(RANDOM_BOUND));
            }

            resultView.racingShow(racingCarList);
        }


    }
}
