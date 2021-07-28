package racingcar.view;

import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView {

    public ConsoleOutputView() {
        System.out.println("실행 결과");
    }

    public void print(RacingGameResponseDto game) {
        Cars cars = game.getCars();
        for (Car car : cars.getElements()) {
            String progressBar = getProgressBar(car.getDistance());
            System.out.println(car.getName().getValue() + " : " + progressBar);
        }
        System.out.println();

        if (game.isFinish()) {
            Winners winners = game.winners();
            System.out.println(getWinners(winners) + "가 최종 우승했습니다.");
        }
    }

    private List<Name> getNames(Winners winners) {
        return winners.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private String getWinners(Winners winners) {
        List<Name> names = getNames(winners);
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.joining(", "));
    }

    private String getProgressBar(Distance distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance.getValue(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
