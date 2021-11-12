package racingcar;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;

    public static void main(String[] args)  {
        InputView innputView;
        try {
            innputView = new InputView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        List<RacingCar> racingCarList = makeRacingCars(carInputView);

//        showRacingCars(tryInputView, racingCarList);
    }

    private static void showRacingCars(InputView tryInputView, List<RacingCar> racingCarList) {
        ResultView resultView = new ResultView();
        Random random = new Random();

        for (int i = 0; i < tryInputView.getTryCount(); i++) {
            goOrStopRacing(racingCarList, random);
            resultView.racingShow(racingCarList);
        }
    }

    private static List<RacingCar> makeRacingCars(InputView carInputView) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carInputView.getTryCount(); i++) {
            racingCarList.add(new RacingCar());
        }
        return racingCarList;
    }

    private static void goOrStopRacing(List<RacingCar> racingCarList, Random random) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.goOrStopRacing(random.nextInt(RANDOM_BOUND));
        }
    }
}
