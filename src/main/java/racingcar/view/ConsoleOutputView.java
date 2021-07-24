package racingcar.view;

import racingcar.controller.dto.CarResponseDto;
import racingcar.controller.dto.RacingGameResponseDto;

import java.util.List;

public class ConsoleOutputView {

    public ConsoleOutputView() {
        System.out.println("실행 결과");
    }

    public void print(RacingGameResponseDto game) {
        for (CarResponseDto car : game.getCars()) {
            String progressBar = getProgressBar(car.getNumberOfMove());
            System.out.println(car.getName() + " : " + progressBar);
        }
        System.out.println();

        if (game.isFinish()) {
            List<String> winners = game.winners();
            System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
        }
    }

    private String getProgressBar(int numberOfMove) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfMove; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
