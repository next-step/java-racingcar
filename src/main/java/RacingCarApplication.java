import racingCar.domain.ForwardPolicyImpl;
import racingCar.domain.RandomNumberGenerator;
import racingCar.ui.InputService;
import racingCar.domain.RacingCar;
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
        ForwardPolicyImpl fowardPolicy = new ForwardPolicyImpl();

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < numberOfCar; j++) {
                cars[j].goForward(RandomNumberGenerator.getRandomNumber());
                PrintService.printDistance(cars[j].showDrivenDistance());
            }
            System.out.println();
        }


    }
}
