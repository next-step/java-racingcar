package CarRacing.view;

import CarRacing.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printCurrentDistance(List<Car> cars) {
        for(int idxCar=0; idxCar < cars.size(); idxCar++) {
            StringBuilder distance = new StringBuilder();
            for (int idxDist=0; idxDist < cars.get(idxCar).current(); idxDist++){
                distance.append("-");
            }
            System.out.print(cars.get(idxCar).getName() + " : " + distance);
            System.out.println();
        }
        System.out.println();
    }

    public static void getWinners(List<Car> cars) {
        int max = 0;
        for (int idxCar=0; idxCar < cars.size(); idxCar++) {
            if (max < cars.get(idxCar).current()) {
                max = cars.get(idxCar).current();
            }
        }

        List<String> winners = new ArrayList<>();
        for (int idxCar=0; idxCar < cars.size(); idxCar++) {
            if (max == cars.get(idxCar).current()) {
                winners.add(cars.get(idxCar).getName());
            }
        }

        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
