package step5.view;

import step5.domain.Car;
import step5.domain.Cars;

import java.util.List;

public class ResultView {
    public static void showAroundRace(Cars cars) {
        List<Car> carList = cars.showCarList();

        for(Car car:carList){
            System.out.println(car);
        }
        System.out.println();
    }

    public static void showWinner(List<Car> carList) {
        StringBuilder winner = new StringBuilder("");
        for(Car car : carList){
            winner.append(car.getName());
            winner.append(",");
        }
        removeLastComma(winner);
        winner.append("가 우승하였습니다.");
        System.out.println(winner);
    }

    private static void removeLastComma(StringBuilder winner) {
        winner.setLength(winner.length()-1);
    }
}
