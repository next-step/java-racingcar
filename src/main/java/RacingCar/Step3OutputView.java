package RacingCar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Step3OutputView implements OutputView {
    final String FORWARD = "-";

    @Override
    public void printTitle() {
        final String TITLE = "실행 결과";
        System.out.println();
        System.out.println(TITLE);
    }

    @Override
    public void printSingleRacingResult(List<Car> cars) {
        cars.forEach(car -> {
            int distance = car.getDistance();
            while (distance-- != 0) {
                System.out.print(FORWARD);
            }
            System.out.print('\n');
        });
        System.out.print('\n');
    }

    @Override
    public void printWinners(List<String> winnersName) {
    }
}
