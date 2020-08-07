package step3.view;

import step3.dto.Car;

import java.util.List;

public class ResultView {

    private final String CAR_MOVING_PATH = "-";

    private final String LINE_FOR_SEPERATE = "";

    public void showCompeetitionPosition(List<Car> cars){
        for(Car car : cars){
            printThisCarPosition(car);
        }
        System.out.println(LINE_FOR_SEPERATE);
    }

    private void printThisCarPosition(Car car){
        int nowPosition = car.nowPosition();

        StringBuilder movePosition = new StringBuilder();

        movePosition.append(car.getEntryNameTag());
        for(int i = 0; i < nowPosition; i++){
            movePosition.append(CAR_MOVING_PATH);
        }

        System.out.println(movePosition.toString());
    }
}
