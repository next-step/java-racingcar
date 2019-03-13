package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANGE = 9;
    private static final String SEPARATOR = ",";
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String carNames) {
        this.createCars(carNames);
    }

    public void createCars(String carNames) {
        for (String carName : carNames.split(SEPARATOR)) {
            this.racingCars.add(new RacingCar(carName.trim()));
        }
    }

    public void playRacing() {
        this.racingCars.forEach(car -> {
            car.move(RandomNumberUtil.createRandomNumber(RANGE));
        });
    }

    public List<RacingCar> getWinner(int tryCount) {
        List<RacingCar> list = this.racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == tryCount)
                .collect(Collectors.toList());
        return list.isEmpty() ? getWinner(tryCount - 1) : list;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
