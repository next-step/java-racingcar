package racingcar.view;

import racingcar.dto.RaceResponse;

import java.util.List;

public final class OutputView {

    private static final String START_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRound(final RaceResponse raceResponse) {
        for (final RaceResponse.CarResponse carResponse : raceResponse.getCars()) {
            System.out.printf("%s : %s%n", carResponse.getName(), carResponse.getPosition());
        }
        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (String winner : winners) {
            stringBuilder.append(winner).append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.printf("%s가 최종 우승했습니다.", stringBuilder);
    }
}
