package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class ResultView {

    public void printResultView(int tryNum, Cars cars){

        for (int num = 0; num < tryNum; num++){
            int stepNum = num;
            cars.getCars().stream().map(car -> printStep(car, stepNum +1)).forEach(System.out::println);
            System.out.println();
        }
    }

    private String printStep(Car car, int num){
        StringBuilder stepString = new StringBuilder();
        for (int i = 0; i < car.getPosition() && i < num ; i++) {
            stepString.append("-");
        }
        return stepString.toString();
    }
}
