import racingCar.domain.RacingCar;
import racingCar.domain.RandomNumberGenerator;
import racingCar.ui.InputService;
import racingCar.ui.PrintService;

public class RacingCarApplication {

    public static void main(String[] args) {
        int numberOfCar, tryCount;

        numberOfCar = InputService.getNumberOfCar();
        tryCount = InputService.getTryCount();

        RacingCar[] cars = new RacingCar[numberOfCar];

        for (int i = 0; i < numberOfCar; i++) {
            cars[i] = new RacingCar();
        }

        System.out.println("실행결과");

        for (int i = 0; i < tryCount; i++) {
            runGame(cars);
            System.out.println();
        }
    }

    public static void runGame(RacingCar[] cars){
        for (int j = 0; j < cars.length; j++) {
            cars[j].goForward(RandomNumberGenerator.getRandomNumber());
            PrintService.printDistance(cars[j].showDrivenDistance());
        }
    }
}
