package racingcar.step5.view;

import racingcar.step5.domain.Car;
import racingcar.step5.domain.Cars;
import racingcar.step5.domain.RacingGame;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_SIGN = "-";
    private static final String PRINT_NAME_DELIMITER = " : ";
    private static final String COMMA = ", ";
    private static final String EXECUTE_MESSAGE = "실행결과";
    private static final String RESULT_MESSAGE = "(이)가 최종 우승했습니다.";

    public void executeMessage() {
        System.out.println(EXECUTE_MESSAGE);
    }

    public void printResult(Cars cars) {
        StringBuilder builder = new StringBuilder();
        cars.getCars().forEach(car -> appendSign(builder, car));
        System.out.println(builder);
    }

    public void printWinners(RacingGame racingGame) {
        StringBuilder builder = new StringBuilder();
        List<Car> winners = racingGame.findWinners();
        int size = winners.size();
        IntStream.range(0, size).forEach(i -> {
            builder.append(winners.get(i).getName());
            appendComma(builder, size, i);
        });
        builder.append(RESULT_MESSAGE);
        System.out.println(builder);
    }

    private void appendSign(StringBuilder builder, Car car) {
        builder.append(car.getName());
        builder.append(PRINT_NAME_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(RESULT_SIGN);
        }
        builder.append('\n');
    }

    private void appendComma(StringBuilder builder, int size, int index) {
        if (index != size - 1) {
            builder.append(COMMA);
        }
    }

}
