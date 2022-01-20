package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars;
    private int roundNumber; //경주 횟수

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void race() throws IOException {
        setRoundNumber();
        while (roundNumber-- > 0) {
            startRound();
            System.out.println();
        }
        printWinner();
    }

    private void startRound() {
        for (Car car : cars) {
            car.move();
            car.printDistance();
        }
    }

    private void setRoundNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("시도할 횟수는 몇회인가요?");
        roundNumber = Integer.parseInt(br.readLine());
    }

    private void printWinner() {
        cars.sort((a, b) -> b.getDistance() - a.getDistance());
        int bestScore = cars.get(0).getDistance();
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (i == 0 || cars.get(i).getDistance() == bestScore) {
                winners.add(cars.get(i).getName());
            }
        }

        System.out.println("최종우승자: " + String.join(", ", winners));
    }
}
