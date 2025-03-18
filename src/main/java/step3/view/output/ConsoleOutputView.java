package step3.view.output;

import step3.game.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConsoleOutputView implements OutputView {

    public static final String WINNER_DELIMETER = ", ";
    public static final String CAR_MOVE_SYMBOL = "-";

    @Override
    public void result() {
        System.out.println("실행 결과");
    }

    @Override
    public String carDistance(Integer distance) {
        return CAR_MOVE_SYMBOL.repeat(distance);
    }

    @Override
    public void endOfThisTurn(Set<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.name.getCarName(), carDistance(car.getDistance()));
        }
        System.out.println();
    }

    @Override
    public void finalResult(Set<Car> cars) {
        int maxDistance = getMaxDistance(cars);

        List<String> winners = getWinners(cars, maxDistance);
        System.out.println(String.join(WINNER_DELIMETER, winners) + "가 최종 우승했습니다.");
    }

    private static List<String> getWinners(Set<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private static int getMaxDistance(Set<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

}
