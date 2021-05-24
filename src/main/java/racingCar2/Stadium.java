package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stadium {

    public int drawRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void run(Car car, int number) {
        car.go(number);
    }

    public String process(int position) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < position; i++) {
            temp.append("-");
        }
        return temp.toString();
    }

    public int findMaxScore(List<Car> cars) {
        int maxScore = 0;
        for (Car car : cars) {
            maxScore = Math.max(maxScore, car.getPosition());
        }
        return maxScore;
    }

    public List<String> winners(List<Car> cars, int maxScore) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxScore) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void winnerIs(List<String> winners) {
        System.out.println("우승자 : " + String.join(",", winners));
    }
}
