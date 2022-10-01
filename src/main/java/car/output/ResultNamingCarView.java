package car.output;

import car.domain.Car;
import car.domain.NamingCar;

import java.util.ArrayList;
import java.util.List;

public class ResultNamingCarView implements ResultView<NamingCar> {

    @Override
    public void print(List<NamingCar> cars, int tryNum) {
        System.out.println("실행 결과");

        for(int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.racing();
                System.out.println(car.printResult());
            }
            System.out.println();
        }
        printWinner(cars);
    }

    private void printWinner(List<NamingCar> cars) {
        List<String> winners = findWinner(cars);
        for (int i = 0; i < winners.size(); i++) {
            printName(i, winners);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private void printName(int idx, List<String> winners) {
        if(idx == winners.size() - 1) {
            System.out.print(winners.get(idx));
            return;
        }
        System.out.print(winners.get(idx) + ", ");
    }

    private List<String> findWinner(List<NamingCar> cars) {
        List<String> winner = new ArrayList<>();

        long max = 0;
        for (NamingCar car : cars) {
            max = Math.max(max, car.raceDistance());
        }
        for (NamingCar car : cars) {
            isWinner(max, car, winner);
        }
        return winner;
    }

    private void isWinner(long max, NamingCar car, List<String> winner) {
        if(max == car.raceDistance()) {
            winner.add(car.getName());
        }
    }
}
