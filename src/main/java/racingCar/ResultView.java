package racingCar;

import java.util.List;

public class ResultView {
    public static void show(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
    public static void showWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i).getName());
            if(i != cars.size()-1) {
                sb.append(", ");
            }
        }
        System.out.println(sb + "가 최종 우승했습니다.");
    }

}
