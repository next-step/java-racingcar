package carracing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {

    public static void raceStart(int carCnt, int tryCnt) {

        List<Car> carList = Stream.generate(Car::new)
                .limit(carCnt)
                .collect(Collectors.toList());

        for(int i = 0; i <tryCnt; i++) {
            carMove(carList);
            ResultView.numberToChar(carList);
        }

    }
    private static void carMove(List<Car> carList) {
        for(Car car : carList) {
            car.move();
        }
    }

}
