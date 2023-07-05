package racingcar.view;

import racingcar.dto.RaceResponse;
import racingcar.domain.CarVO;

public class OutputView {
    private static final String START_MESSAGE = "실행 결과";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRound(RaceResponse raceResponse) {
        for (CarVO carVO : raceResponse.getCars()) {
            System.out.printf("%s : %s%n", carVO.getName(), carVO.getPosition());
        }
        System.out.println();
    }

    public static void printWinners(String[] winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.length - 1; i++) {
            stringBuilder.append(winners[i]).append(',');
        }
        stringBuilder.append(winners[winners.length - 1]);
        System.out.printf("%s가 최종 우승했습니다.", stringBuilder);
    }
}
