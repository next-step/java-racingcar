package racing.view;

import racing.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static int WINNER_POSITION_IDX = 0;

    public static void showResult(List<Car> cars, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            showEachCarRecord(cars, i);
        }
    }

    public static void showWinner(List<Car> cars) {
        cars.sort((o1, o2) -> {
            return makeDescending(o1, o2);
        });

        int winnerPosition = cars.get(WINNER_POSITION_IDX).getPosition();

        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            makeWinnerString(winnerPosition, sb, car);
        }

        System.out.println(sb.toString().substring(0, sb.lastIndexOf(","))+"가 최종 우승했습니다.");
    }

    private static int makeDescending(Car o1, Car o2) {
        if (o1.getPosition() > o2.getPosition())
            return -1;
        if (o1.getPosition() < o2.getPosition())
            return 1;
        return 0;
    }

    private static void makeWinnerString(int winnerPosition, StringBuilder sb, Car car) {
        if (car.getPosition() == winnerPosition) {
            sb.append(car.getName()+", ");
        }
    }

    private static void showEachCarRecord(List<Car> cars, int carNum) {
        for (Car car : cars) {
            int record = (int)car.getRecord().get(carNum);
            showEachRecord(car.getName(), record);
        }
        System.out.println();
    }

    private static void showEachRecord(String carName, int record) {
        System.out.print(carName + " : ");
        for (int j = 0; j < record; j++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
