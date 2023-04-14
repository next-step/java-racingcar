package entity.race;

import entity.NumberGenerator;
import entity.RandomNumberGenerator;
import util.View;


public class CarRace {

    private final RacingCars racingCars;
    private final RaceRound round;

    //외부에서 생성자 호출 막기
    private CarRace(RacingCars racingCars, RaceRound round) {
        this.racingCars = racingCars;
        this.round = round;
    }

    public static CarRace initRace(int numberOfCar, int round, String carName) {
        return new CarRace(RacingCars.of(numberOfCar, carName), RaceRound.of(round));
    }

    public int getRoundValue() {
        return round.getValue();
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public void race() {
        for (int i = 1; i <= round.getValue(); i++) {
            racing();
            recordRace(i);
        }
        View.printWinner(racingCars.getHeadOfRace());
    }

    private void racing() {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        racingCars.getCars()
                .forEach(car -> car.moveCar(numberGenerator));
    }

    private void recordRace(int count) {
        View.printRound(count);
        for (int i = 0; i < racingCars.getCars().size(); i++) {
            int record = racingCars.getCars().get(i).getPositionValue();
            View.printRecord(racingCars.getCars().get(i), record);
        }
    }


}
