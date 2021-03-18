package racing.views;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersView extends View<Void, List<Car>> {
    @Override
    public Void show(List<Car> winnerList) {
        final String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");

        return null;
    }
}
