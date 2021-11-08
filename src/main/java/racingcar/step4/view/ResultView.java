package racingcar.step4.view;

import racingcar.step4.domain.Car;
import racingcar.step4.domain.Cars;
import racingcar.step4.service.RacingGame;

public class ResultView {

    private static final String RESULT_SIGN = "-";
    private static final String PRINT_NAME_DELIMITER = " : ";
    private static final String EXECUTE_MESSAGE = "실행결과";

    public void executeMessage() {
        System.out.println(EXECUTE_MESSAGE);
    }

    public void resultPrint(Cars cars) {
        StringBuilder builder = new StringBuilder();
        cars.getCars().forEach(car -> builderAppendSign(builder, car));
        System.out.println(builder);
    }

    private void builderAppendSign(StringBuilder builder, Car car) {
        builder.append(car.getName());
        builder.append(PRINT_NAME_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(RESULT_SIGN);
        }
        builder.append('\n');
    }

    public void winnersPrint(RacingGame racingGame) {
        StringBuilder builder = new StringBuilder();
        racingGame.findWinners()
                .forEach(c ->{
                    builder.append(c.getName());
                    builder.append(" ");
                });
        builder.append("(이)가 최종 우승했습니다.");
        System.out.println(builder);
    }
}
