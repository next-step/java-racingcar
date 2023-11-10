package racing;

import static racing.model.Cars.getWinners;

import java.util.ArrayList;
import java.util.List;
import racing.model.Cars;
import racing.model.RacingCar;
import racing.view.InputView;
import racing.view.ResultView;

public class Simulator {
    private static final int BEGINNING = 0;

    static String[] carName;
    static int carCount;
    static int raceRound;

    public static void main(String[] args) throws IllegalAccessException {
        carName = InputView.getCarName();
        carCount = carName.length;
        raceRound = InputView.getRaceRound();
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar(BEGINNING, carName[i]));
        }
        Cars car = new Cars(racingCars);
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < raceRound; i++) {
            car.raceAllCars();
            System.out.println();
        }
        ResultView.showWinners(getWinners(racingCars));
    }

}
