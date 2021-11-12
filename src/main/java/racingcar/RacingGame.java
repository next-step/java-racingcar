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
        InputView inputView = null;
        try {
            inputView = new InputView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<RacingCar> racingCarList = makeRacingCars(inputView);
        showRacingCars(inputView, racingCarList);
    }

    private static void showRacingCars(InputView inputView, List<RacingCar> racingCarList) {
        ResultView resultView = new ResultView();
        Random random = new Random();

        for (int i = 0; i < inputView.getTryCount(); i++) {
            goOrStopRacing(racingCarList, random);
            resultView.racingShow(racingCarList);
        }
    }

    private static List<RacingCar> makeRacingCars(InputView inputView) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : inputView.getCarNames()) {
            racingCarList.add(new RacingCar(carName));
        }
        return racingCarList;
    }

    private static void goOrStopRacing(List<RacingCar> racingCarList, Random random) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.goOrStopRacing(random.nextInt(RANDOM_BOUND));
        }
    }
}
