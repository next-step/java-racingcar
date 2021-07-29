import racingCar.ui.InputService;
import racingCar.domain.RacingCar;

public class RacingCarApplication {

    public static void main(String[] args) {
        int numberOfCar, tryCount;

        numberOfCar = InputService.getNumberOfCar();
        tryCount = InputService.getTryCount();

        RacingCar[] cars = new RacingCar[numberOfCar];

        System.out.println("실행결과");


    }
}
