package racing;

import java.util.*;

public class Racing {
    private Players players;
    private PrintResult printResult;
    private int numberOfPlay;
    private RandomGenerator randomGenerator;

    public Racing(String carNames, int numberOfPlay) {
        this.printResult = new PrintResult();
        this.players = new Players(carNames);
        this.numberOfPlay = numberOfPlay;
    }

    public Racing(List<Car> cars) {
        this.players = new Players(cars);
    }

    public List race() {
        for (int play = 0; play < numberOfPlay; play++) {
            random();
        }

        List<String> winner = printResult.printWinner(players);

        return winner;
    }

    public void random() {
        for (Car car : players.getCars()) {
            moved(randomGenerator.create(), car);
            System.out.print(car.getName() + " : ");
            printResult.printTrace(car);
            System.out.println();
        }
    }

    public void moved(int random, Car car) {
        if (random > 4) {
            car.moved();
        }
    }
}
