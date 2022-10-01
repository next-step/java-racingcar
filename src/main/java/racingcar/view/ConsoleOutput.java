package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ConsoleOutput {

    private static final String RACING_RESULT_MESSAGE = "레이싱 게임 결과입니다.";
    private static final String RAIL = "-";
    private static final String STATUS_FORMAT = "%s : %s%n";
    private static final String COMMA = ", ";
    private static final String WIN_MESSAGE = "가 최종 우승했습니다.";

    public void resultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void status(List<Car> carStatusDto) {
        carStatusDto.forEach(
                carStatus -> System.out.printf(STATUS_FORMAT, carStatus.getName(), rails(carStatus.getPosition()))
        );
        newLine();
    }

    private String rails(int position) {
        return RAIL.repeat(Math.max(0, position));
    }

    public void winner(List<Car> carStatusDtos) {
        for (int i = 0; i < carStatusDtos.size(); i++) {
            printComma(i);
            System.out.print(carStatusDtos.get(i).getName());
        }
        System.out.println(WIN_MESSAGE);
    }

    private void printComma(int i) {
        if (i != 0) {
            System.out.print(COMMA);
        }
    }

    private void newLine() {
        System.out.println();
    }
}
