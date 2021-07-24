package racingcar.view;

import racingcar.controller.dto.CarResponseDto;
import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.domain.Distance;
import racingcar.domain.Name;

import java.util.List;

public class ConsoleOutputView {

    public ConsoleOutputView() {
        System.out.println("실행 결과");
    }

    public void print(RacingGameResponseDto game) {
        for (CarResponseDto car : game.getCars()) {
            String progressBar = getProgressBar(car.getDistance());
            System.out.println(car.getName() + " : " + progressBar);
        }
        System.out.println();

        if (game.isFinish()) {
            List<Name> winners = game.winners();
            System.out.println(String.join(", ", winners.toString()) + "가 최종 우승했습니다.");
        }
    }

    private String getProgressBar(Distance distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance.getValue(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
