package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class ResultView {

    private ResultView() {
    }
    public static void printStartResult(){
        System.out.println("실행 결과");
    }
    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getShowDistance());
        }
    }

    public static void printWinners(Cars cars) {
        final StringBuilder sb = new StringBuilder();

        for (Car car : cars.isWinners()){
            if(sb.length() == 0){
                sb.append(car.getCarName());
            } else {
                sb.append(", " + car.getCarName());
            }
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
