import java.util.Arrays;
import java.util.stream.IntStream;

public class ResultView {

    public void printRaceCondition(RacingCar[] racingCars) {
        System.out.println("실행 결과");

        Arrays.stream(racingCars).forEach(racingCar -> {
            int distance = racingCar.getPosition();
            System.out.println("-".repeat(distance));
        });
    }
}
