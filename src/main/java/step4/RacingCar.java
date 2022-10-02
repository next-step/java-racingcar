package step4;

public class RacingCar {

    public static void run() {
        InputRacingCar inputRacingCar = new InputRacingCar();
        Position position = new Position();
        Racing racing = new Racing();

        Car car = inputRacingCar.input();
        position.initPosition(car.getNames());

        for (int i = 0 ; i < car.getTimes() ; i++) {
            racing.racingRound(position, car.getNames());
        }
    }
}
