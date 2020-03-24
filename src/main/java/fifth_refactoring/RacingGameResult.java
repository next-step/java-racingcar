package fifth_refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameResult {

    public void announceRank(List<Car> car) {
        String firstCarName = setRank(car);
        System.out.println(firstCarName + "가 최종 우승했습니다.");
    }

    public String setRank(List<Car> car) {
        Collections.sort(car);

        int maxPosition = car.get(car.size()-1).getCarPosition();

        String firstCarName = car.stream()
                .filter(d -> d.getCarPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        return firstCarName;
    }
}
