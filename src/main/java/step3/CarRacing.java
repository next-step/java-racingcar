package step3;

public class CarRacing {
    private final Cars racingCars;
    private final Referee referee;
    private final int howManyTimes;

    private CarRacing(Cars racingCars, Referee referee,int howManyTimes) {
        this.racingCars = racingCars;
        this.referee = referee;
        this.howManyTimes = howManyTimes;
    }

    public static CarRacing setting(Cars cars , Referee referee, int howManyTimes) {
        return new CarRacing(cars,referee,howManyTimes);
    }

    public void start(OutPutView outPutView) {
        racingCars.start(this.referee, this.howManyTimes,outPutView);
    }

    public void result(OutPutView outPutView) {
        racingCars.result(outPutView);
    }
}
