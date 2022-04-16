package racingcar;

import racingcar.view.ResultView;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar implements NumberGenerator {
    private List<Car> cars;
    private int round;
    private ResultView resultView;
    private SecureRandom random = new SecureRandom();

    public RacingCar(List<Car> cars, int round, ResultView resultView) {
        this.cars = cars;
        this.setRound(round);
        this.resultView = resultView;
    }

    private void setRound(int round) {
        if(round < 0) {
            throw new IllegalArgumentException("round는 음수가 될 수 없습니다");
        }
        this.round = round;
    }

    private List<Car> getCars() {
        return this.cars;
    }

    public int playRacing() {
        for (int currentRound = 0; currentRound < round; currentRound++) {
            playRound();
            resultView.printCarsMovingDistance(getCurrentRacingResult());
        }
        return round;
    }

    private List<Integer> getCurrentRacingResult() {
        return getCars().stream().map(car -> car.getDistance()).collect(Collectors.toList());
    }

    private void playRound() {
        for (Car car:cars) {
            car.play(generateNumber());
        }
    }

    @Override
    public int generateNumber() {
        return this.random.nextInt(MAX +1);
    }
}
