package study.racing.view;

import static study.racing.view.InsertView.printMessage;
import static study.racing.view.InsertView.printNewLine;

import java.util.List;
import study.racing.common.Message;
import study.racing.domain.Car;

public class DrawDisplay {

    private static final String CAR_PROGRESS_BAR = "-";

    public DrawDisplay(List<Car> cars) {
        cars.forEach(o->drawProgressBar(o.getName().getCarName(),o.getDistance().getMoveDistance()));
        printNewLine();
    }

    private void drawProgressBar(String carName, int moveDistance) {
        StringBuilder carModel = new StringBuilder();

        for(int i = 0; i < moveDistance; i++){
            carModel.append(CAR_PROGRESS_BAR);
        }
        printMessage(carName + Message.MSG_RESULT_FORM + carModel);
    }

    public void drawProgressBar(int moveDistance) {
        StringBuilder carModel = new StringBuilder();

        for(int i = 0; i < moveDistance; i++){
            carModel.append(CAR_PROGRESS_BAR);
        }
        printMessage(Message.MSG_RESULT_FORM + carModel);
    }
}
