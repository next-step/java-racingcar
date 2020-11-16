package step3.domain;

public class CarRacing {

    private Cars cars;
    private int totalTries;

    private MoveCondition moveCondition = new MoveCondition() {
        static final int MIN_FOR_MOVE = 4;

        private RaceRoulette raceRoulette = RaceRoulette.simple(9);
        @Override
        public boolean match() {
            return raceRoulette.spin() >= MIN_FOR_MOVE;
        }
    };

    public CarRacing(String carNames, int totalTries) {
        this.cars = new Cars(carNames);
        this.totalTries = totalTries;
    }

    public void tryMovingAllCars() {
        this.cars.tryMoving(moveCondition);
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
