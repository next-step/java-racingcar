package step3.domain;

public class CarRacing {

    private Cars cars;

    private int nextTry;
    private int totalTries;

    private final RaceRoulette DEFAULT_RACE_ROULETTE = RaceRoulette.simple(9);
    private RaceRoulette raceRoulette;

    public CarRacing(String carNames, int totalTries) {
        this.cars = new Cars(carNames);
        this.totalTries = totalTries;
        this.nextTry = 1;
        this.raceRoulette = DEFAULT_RACE_ROULETTE;
    }

    public void tryMovingAllCars() {
        this.cars.tryMoving(() -> raceRoulette.spin() >= 4);
        this.nextTry++;
    }

    public boolean isFinish(){
        return this.nextTry > this.totalTries;
    }

    public RaceState getRaceState() {
        return new RaceState(this.cars.getCarStates());
    }

    public RaceResult getRaceResult(){
        return new RaceResult(cars.findRaceWinner(new RaceWinnerFinder()));
    }

}
