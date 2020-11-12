package step3.domain;

public class CarRacing {

    private JoinedCars joinedCars;

    private int nextTry;
    private int totalTries;

    private final RaceRoulette DEFAULT_RACE_ROULETTE = RaceRoulette.simple(9);
    private RaceRoulette raceRoulette;

    public CarRacing(String carNames, int totalTries) {
        this.joinedCars = new JoinedCars(carNames);
        this.totalTries = totalTries;
        this.nextTry = 1;
        this.raceRoulette = DEFAULT_RACE_ROULETTE;
    }

    public void tryMovingAllCars() {
        this.joinedCars.tryMoving(this.raceRoulette);
        this.nextTry++;
    }

    public boolean isFinish(){
        return this.nextTry > this.totalTries;
    }

    public RaceState getRaceState() {
        return new RaceState(this.joinedCars.getCarStates());
    }

    public RaceResult getRaceResult(){
        return new RaceResult(joinedCars.findRaceWinner(new RaceWinnerFinder()));
    }

}
