package step3.view;

import step3.dto.Car;

import java.util.List;

public class ResultView {

    private final String CAR_MOVING_PATH = "-";

    public void showCompeetitionPosition(List<Car> cars){
        for(Car car : cars){
            printThisCarPosition(car);
        }
    }

    private void printThisCarPosition(Car car){
        int nowPosition = car.nowPosition();

        StringBuilder movePosition = new StringBuilder();

        for(int i = 0; i < nowPosition; i++){
            movePosition.append(CAR_MOVING_PATH);
        }

        System.out.println(movePosition.toString());
    }
}
