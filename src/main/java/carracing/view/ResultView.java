package carracing.view;

import carracing.domain.Car;

import java.util.List;


public class ResultView {

    public void outputResult(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            System.out.print(carName + " : ");
            int carLocation = car.getLocation();
            for (int i = 0; i < carLocation; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void resultStart() {
        System.out.println("\n실행결과");
    }

    public void outputWinnersName(String winners) {
        System.out.println(winners + "(이)가 최종 우승했습니다.");
    }
}
