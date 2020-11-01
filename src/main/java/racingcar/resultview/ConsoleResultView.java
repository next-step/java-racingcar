package racingcar.resultview;

import racingcar.domain.RacingCar;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ConsoleResultView implements ResultView {
    private static final String PROGRESS_BAR = "-";
    private static final String NAME_PUNCTUATION_MARK  = ": ";

    @Override
    public void printProgress(List<RacingCar> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (RacingCar car : cars) {
            stringBuilder.append(car.name).append(NAME_PUNCTUATION_MARK);
            car.repeatAsMoveCount(() -> stringBuilder.append(PROGRESS_BAR));
            stringBuilder.append(System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }

    @Override
    public void printWinners(List<RacingCar> winners) {
        String collect = winners.stream()
                .map(racingCar -> racingCar.name)
                .collect(joining(","));

        System.out.println(collect + "가 최종 우승했습니다.");
    }
}
