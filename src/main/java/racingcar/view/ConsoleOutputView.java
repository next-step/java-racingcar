package racingcar.view;

import racingcar.controller.dto.CarResponseDto;
import racingcar.controller.dto.RacingGameResponseDto;

import java.util.List;
import java.util.stream.Collectors;

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
            System.out.println(winners(game.getCars()));
        }
    }

    private String winners(List<CarResponseDto> cars) {
        int max = cars.stream()
                .mapToInt(CarResponseDto::getNumberOfMove)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        String names = cars.stream()
                .filter(r -> r.getNumberOfMove() == max)
                .map(CarResponseDto::getName)
                .collect(Collectors.joining(", "));

        return names + "가 최종 우승했습니다.";
    }

    private String getProgressBar(int numberOfMove) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfMove; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
