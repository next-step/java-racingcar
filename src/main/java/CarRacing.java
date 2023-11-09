public class CarRacing {
    private Cars racingCars;
    private Referee referee;

    private CarRacing(Cars racingCars, Referee referee) {
        this.racingCars = racingCars;
    }

    public static CarRacing gameSetting(Cars cars , Referee referee) {
        return new CarRacing(cars,referee);
    }

    public void start(int howManyTimes) {
        racingCars.start(referee, howManyTimes);
    }
}
