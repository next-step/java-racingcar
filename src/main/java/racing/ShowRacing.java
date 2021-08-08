package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowRacing {

    public static void showGame(Integer cntSize, String carName) {

        String movement = "";

        System.out.print(carName + " : ");

        for(int cnt = 0; cnt < cntSize; cnt++) {
            movement = movement + "-";
        }

        System.out.println(movement);

    }

    public static void showWinner(List<Car> carList) {

        StringBuilder winners = new StringBuilder();

        for(Car car : carList) {
            winners.append(car.getCarName());
            winners.append(", ");
        }

        System.out.println(winners.substring(0, winners.length()-2) + "가 최종 우승했습니다.");

    }
}
