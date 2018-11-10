package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    static final int RANGE_OF_NUM = 10;

    private List<Car> cars;

    public RacingGame(String carNames) {
        String names[] = carNames.split(",");
        cars = new ArrayList<>();
        for(int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> onTheGame(Random rand) {
        for(Car car : cars) {
            int currentPos = rand.nextInt(RANGE_OF_NUM);
            car.move(currentPos);
        }
        return cars;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        String carNames = InputView.getCarsNames();
        int racingTracks = InputView.getRacingTracks();

        RacingGame racingGame = new RacingGame(carNames);
        List<Car> result = new ArrayList<>();

        for(int i = 0; i < racingTracks; i++) {
            result = racingGame.onTheGame(rand);
            DisplayView.print(result);
            System.out.println();
        }
        ResultView.printWinner(result);
    }
}
