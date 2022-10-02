package step4;

public class RacingCar {

    public static void run() {
        InputRacingCar inputRacingCar = new InputRacingCar();
        Position position = new Position();
        Racing racing = new Racing();
        Result result = new Result();
        OutputResult outputResult = new OutputResult();

        Car car = inputRacingCar.input();

        position.initPosition(car.getNames());

        outputResult.printTitle();

        racing.racing(position, car, outputResult);

        result.findWinner(position.getPositions());

        outputResult.printResult(result.getWinner());
    }
}
