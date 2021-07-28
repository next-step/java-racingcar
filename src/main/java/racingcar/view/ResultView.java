package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    public static void printMovingCars(Cars cars){
        for (Car car : cars.getCars()) {
            printMovingCar(car);
        }
        System.out.println();
    }

    private static void printMovingCar(Car car) {
        System.out.print(car.getName() + " : ");
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        StringBuffer sb = new StringBuffer(winners);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
