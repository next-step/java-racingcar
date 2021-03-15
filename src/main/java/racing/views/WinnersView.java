package racing.views;

import racing.models.Car;
import racing.models.Racing;

import java.util.stream.Collectors;

public class WinnersView extends View<Void, Racing> {
    @Override
    public Void show(Racing racing) {
        final String winnerNames = racing.getWinnerList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");

        return null;
    }
}
