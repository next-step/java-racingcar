package racing.views;

import racing.models.Car;
import racing.models.Round;

import java.util.stream.Collectors;

public class WinnersView extends View<Void, Round> {
    @Override
    public Void show(Round round) {
        final String winnerNames = round.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");

        return null;
    }
}
