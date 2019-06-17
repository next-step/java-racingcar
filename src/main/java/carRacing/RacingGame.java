package carRacing;

import java.util.List;

public class RacingGame {

    private int numberOfCars;
    private int numberOfLaps;

    public RacingGame(int numberOfCars, int numberOfLaps) {
        validateNumberOfCars(numberOfCars);
        validateNumberOfLaps(numberOfLaps);
        this.numberOfCars = numberOfCars;
        this.numberOfLaps = numberOfLaps;
    }

    public List<Car> startRace(){

        Engine engine = new RandomEngine();
        RaceLap raceLap = new RaceLap(engine, this.numberOfCars);

        ResultView resultView = new ResultView();
        for (int i = 0; i < this.numberOfLaps; i++) {
            List<Car> cars = raceLap.race().getCars();
            resultView.printRacingResult(cars);
        }
        return raceLap.getCars();
    }

    private void validateNumberOfCars(int numberOfCars){
        if(numberOfCars < 1) throw new IllegalArgumentException("한 대 이상의 차가 참가 해야 합니다.");
    }

    private void validateNumberOfLaps(int numberOfCars){
        if(numberOfCars < 1) throw new IllegalArgumentException("1회 이상 실행 되어야 합니다.");
    }
}
