package step4.view;

import step4.domain.car.Car;
import step4.domain.car.position.Position;

import step4.domain.racing.Cars;
import step4.domain.racing.Winners;
import step4.dto.ResponseDto;

import java.util.List;

public final class ResultView {

    private static ResultView instance;

    private ResultView() {
    }

    public static final ResultView getInstance() {
        if (isInstanceNull()) {
            instance = new ResultView();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    public final void printRacingEndMessage() {
        System.out.println("실행 결과");
    }

    public final void print(ResponseDto responseDto) {
        Cars cars = responseDto.cars();
        List<Car> carList = cars.cars();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            stringBuilder.append(car.name().name()).append(" : ");
            int index = 0;
            while (car.isDifferentPosition(new Position(index))){
                stringBuilder.append("-");
                index++;
            }
            stringBuilder.append("\n");
        }
        print(stringBuilder);

    }

    public final void print(Winners winners) {
        StringBuilder stringBuilder = new StringBuilder();
        winners.winners().stream()
                .forEach(winner -> stringBuilder.append(winner.name().name()).append(","));

        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append("가 최종 우승했습니다.");

       print(stringBuilder);
    }

    private final void print(StringBuilder stringBuilder) {
        System.out.println(stringBuilder.toString());
    }


}
