package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.car.Car;
import racingcar.dto.RacingCarResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String COMMA = ",";
    private static final String COLON = " : ";

    public void printRacingScores(List<Cars> cars) {
        System.out.println("실행 결과");
        for (Cars score : cars) {
            printScore(score.getCars());
        }
    }

    private void printScore(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder(car.getName());
        stringBuilder.append(COLON);
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        System.out.println(stringBuilder.toString());
    }

    public void printWinner(List<Car> winner) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winner) {
            winnerNames.add(car.getName());
        }
        System.out.println(String.join(COMMA, winnerNames) + "가 최종 우승했습니다.");
    }

    public void printResult(RacingCarResponseDto racingCarResponseDto) {
        printRacingScores(racingCarResponseDto.getCars());
        printWinner(racingCarResponseDto.getWinners());
    }
}
