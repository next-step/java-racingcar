package study.racing.view;

import static study.racing.view.InsertView.printMessage;
import static study.racing.view.InsertView.printNewLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.racing.common.Message;
import study.racing.domain.Car;

public class DrawDisplay {

    private static final String CAR_PROGRESS_BAR = "-";
    public static final String REST_MARK = ",";

    public DrawDisplay(List<Car> cars) {
        cars.forEach(o->drawProgressBar(o.getName().getCarName(),o.getDistance().getMoveDistance()));
        printNewLine();
    }

    public DrawDisplay() {
    }

    private void drawProgressBar(String carName, int moveDistance) {
        String carModel = IntStream.range(0, moveDistance).mapToObj(i -> CAR_PROGRESS_BAR)
            .collect(Collectors.joining());

        printMessage(carName + Message.MSG_RESULT_FORM + carModel);
    }

    public void drawProgressBar(int moveDistance) {
        String carModel = IntStream.range(0, moveDistance).mapToObj(i -> CAR_PROGRESS_BAR)
            .collect(Collectors.joining());

        printMessage(Message.MSG_RESULT_FORM + carModel);
    }

    public void resultGame(List<Car> cars){
        StringBuilder carName = new StringBuilder();
        int index = 1;

        for (Car car : cars) {
            carName.append(car.getName().getCarName());
            appendRestMark(cars, carName, index);
            index++;
        }
        printMessage(carName+Message.MSG_RESULT_WINNERS_NAME);
    }

    private void appendRestMark(List<Car> cars, StringBuilder carName, int index) {
        if(cars.size() > index){
            carName.append(REST_MARK);
        }
    }
}
