package racingcar.step4.view;

import racingcar.step4.domain.Car;
import racingcar.step4.domain.Cars;

public class ResultView {

    private static final String SIGN = "-";
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
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(SIGN);
        }
        builder.append('\n');
    }

}
