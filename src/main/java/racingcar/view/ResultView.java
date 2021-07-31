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
        // get을 없애려고 하는데 이부분에서 막히네요 ㅠㅠ carposition의 position값을 알아야 하는데 다른 방법이 있을까요??
        for(int i=0; i<car.getPosition().getPosition(); i++){
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
