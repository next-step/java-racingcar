package racingcar.view;

import racingcar.model.dto.CarDto;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class WinnerResultView implements View {
    private static final String NAMES_JOIN_DELIMITER = ", ";
    private final List<CarDto> winners;

    public WinnerResultView(List<CarDto> winners) {
        this.winners = winners;
    }

    @Override
    public void render() {
        String winnerNames = winners.stream()
                .map(CarDto::name)
                .collect(joining(NAMES_JOIN_DELIMITER));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
