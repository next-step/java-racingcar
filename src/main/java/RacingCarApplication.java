import racingCar.domain.FowardPolicyImpl;
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
        FowardPolicyImpl fowardPolicy = new FowardPolicyImpl();

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < numberOfCar; j++) {
                if(fowardPolicy.isMovableNumber(RandomNumberGenerator.getRandomNumber())) {
                    cars[j].goForward();
                }
                PrintService.printDistance(cars[j].showDrivenDistance());
            }
            System.out.println();
        }


    }
}
