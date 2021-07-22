package racingcar.view;

import racingcar.controller.dto.CarResponseDto;

import java.util.List;

public class ConsoleOutputView {

    public ConsoleOutputView() {
        System.out.println("실행 결과");
    }

    public void print(List<CarResponseDto> cars) {
        for (CarResponseDto car : cars) {
            String progressBar = getProgressBar(car.getNumberOfMove());
            System.out.println(progressBar);
        }
        System.out.println();
    }

    private String getProgressBar(int numberOfMove) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfMove; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
