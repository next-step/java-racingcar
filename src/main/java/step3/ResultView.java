package step3;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private ResultView() {}

    public static void printRaceResult(CarRacing carRacing, Duration roundInterval)
        throws InterruptedException {
        System.out.println("실행 결과");
        List<Car> cars = carRacing.currentCars();
        Map<Car, Integer> orderMap = IntStream.range(0, cars.size())
            .boxed()
            .collect(Collectors.toMap(
                cars::get, i -> i
            ));

        while (carRacing.getTryCount() > 0) {
            List<Car> racingCars = carRacing.racingCars();
            String board = racingCars.stream()
                .sorted(Comparator.comparingInt(orderMap::get)) // 기준 순서대로 정렬
                .map(car -> "-".repeat(car.getDistance()))                       // 각 자동차의 "---" 문자열 생성
                .collect(Collectors.joining("\n"));
            System.out.println(board);
            sleep(roundInterval);
            System.out.println();
        }
    }

    private static void sleep(Duration roundInterval) throws InterruptedException {
        if (roundInterval.isPositive()) {
            Thread.sleep(roundInterval.toMillis());
        }
    }
}
