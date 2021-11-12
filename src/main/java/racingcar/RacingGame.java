package racingcar;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final String NUMBER_OF_CAR_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_TRY_MSG = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView carInputView = new InputView(NUMBER_OF_CAR_MSG, scanner);
        InputView tryInputView = new InputView(NUMBER_OF_TRY_MSG, scanner);

        ResultView resultView = new ResultView();
        System.out.println();
        System.out.println("실행 결과");

        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carInputView.getCount(); i++) {
            racingCarList.add(new RacingCar());
        }

        for (int i = 0; i < tryInputView.getCount(); i++) {
            goOrStopRacing(racingCarList);
            resultView.racingShow(racingCarList);
        }
    }

    private static void goOrStopRacing(List<RacingCar> racingCarList) {
        Random random = new Random();
        for (RacingCar racingCar : racingCarList) {
            racingCar.goOrStopRacing(random.nextInt(RANDOM_BOUND));
        }
    }

}
