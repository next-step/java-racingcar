package carracing.view;

import carracing.domain.Car;

import java.util.Arrays;
import java.util.List;


public class ResultView {

    public void outputResult(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            System.out.print(carName + " : ");
            printMove(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    private void printMove(int carLocation) {
        for (int i = 0; i < carLocation; i++) {
            System.out.print("-");
        }
    }

    public void resultStart() {
        System.out.println("\n실행결과");
    }

    public void outputWinnersName(List<String> winners) {
        System.out.println(putComma(winners) + "(이)가 최종 우승했습니다.");
    }

    private static String putComma(List<String> listWinnersName) {
        String winnersName = String.join(", ", listWinnersName);
        return winnersName;
    }
}
