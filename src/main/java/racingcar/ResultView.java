package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public void showRaceResult(List<Car> cars) {
        for (Car car : cars) {
            showResult(car);
        }
        System.out.println();
    }

    private void showResult(Car car) {
        System.out.print(car.getCarName() + ": ");
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinner(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i).getCarName());
            builder.append(", ");
        }

        String result = builder.toString();
        int lastIndex = result.lastIndexOf(",");
        result = result.substring(0, lastIndex);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    List<Car> sortByValue(List<Car> carList) {
        carList.sort((o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) return 1;
            return -1;
        });

        return carList;
    }

    List<Car> getWinners(List<Car> cars) {
        sortByValue(cars);
        List<Car> winners = new ArrayList<>();
        Car winner = cars.get(0);

        for (Car car : cars) {
            checkWinner(car, winner, winners);
        }

        return winners;
    }

    private void checkWinner(Car car, Car winner, List<Car> winners) {
        if (car.isMaxPosition(winner)) {
            winners.add(car);
        }
    }
}
