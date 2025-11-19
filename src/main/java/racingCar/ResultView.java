package racingCar;

import java.util.List;

public class ResultView {
    public static void show(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
    public static void showWinner(Winners winners) {
        StringBuilder sb = new StringBuilder();
        List<Car> winnerList = winners.value();
        for(int i = 0; i < winnerList.size(); i++) {
            sb.append(winnerList.get(i).getName());
            if(i != winnerList.size()-1) {
                sb.append(", ");
            }
        }
        System.out.println(sb + "가 최종 우승했습니다.");
    }

}
