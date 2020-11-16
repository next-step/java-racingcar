package step3.domain;

public class CarRacing {

    private final RaceRoulette DEFAULT_RACE_ROULETTE = RaceRoulette.simple(9);

    private Cars cars;

    private int totalTries;

    private RaceRoulette raceRoulette;

    public CarRacing(String carNames, int totalTries) {
        this.cars = new Cars(carNames);
        this.totalTries = totalTries;
        this.raceRoulette = DEFAULT_RACE_ROULETTE;
    }

    public void tryMovingAllCars() {
        this.cars.tryMoving(() -> raceRoulette.spin() >= 4);
    }

    public boolean isInCarRacing(){
        return this.cars.isRemainingTry(this.totalTries);
    }

    public RaceState getRaceState() {
        return new RaceState(this.cars.getCarStates());
    }

    public RaceResult getRaceResult(){
        return new RaceResult(cars.findRaceWinner(new RaceWinnerFinder()));
    }

}
