package racingcar;

import java.util.List;

public class ConsoleOutput {

    private static final String RACING_RESULT_MESSAGE = "레이싱 게임 결과입니다.";
    private static final String RAIL = "-";
    private static final String STATUS_FORMAT = "%s : %s%n";

    public void resultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void status(List<CarStatusDto> carStatusDto) {
        carStatusDto.forEach(carStatus -> System.out.printf(STATUS_FORMAT, carStatus.getName(), rails(carStatus.getPosition())));
        newLine();
    }

    private String rails(int position) {
        return RAIL.repeat(Math.max(0, position));
    }

    private void newLine() {
        System.out.println();
    }
}
