package study.racing.view;

import study.racing.common.Message;
import study.racing.domain.Car;

import java.util.List;

import static study.racing.common.Common.printMessage;
import static study.racing.common.Common.printNewLine;

public class DrawDisplay {

    private static final String CAR_PROGRESS_BAR = "-";

    public DrawDisplay(List<Car> cars) {
        cars.forEach(o->drawProgressBar(o.getDistance().getMoveDistance()));
        printNewLine();
    }

    public void drawProgressBar(int moveDistance) {
        StringBuilder carModel = new StringBuilder();

        for(int i = 0; i < moveDistance; i++){
            carModel.append(CAR_PROGRESS_BAR);
        }
        printMessage(Message.MSG_RESULT_FORM + carModel);
    }
}
