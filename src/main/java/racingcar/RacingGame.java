package racingcar;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    private static void showRacingCars(InputView inputView, List<RacingCar> racingCars) {
        ResultView resultView = new ResultView();
        Random random = new Random();

        for (int i = 0; i < inputView.getTryCount(); i++) {
            goOrStopRacing(racingCars, random);
            resultView.racingShow(racingCars);
        }

        resultView.drawWinner(getWinner(racingCars));
    }

    private static List<RacingCar> getWinner(List<RacingCar> racingCars) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.isMoveCountEqualMaxCount(getMaxCount(racingCars)))
                .collect(Collectors.toList());
    }

    private static int getMaxCount(List<RacingCar> racingCars) {
        return racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getMoveCount))
                .get().getMoveCount();
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
