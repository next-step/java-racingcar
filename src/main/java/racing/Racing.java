package racing;

import java.util.*;

public class Racing {
    private Players players;
    private PrintResult printResult;
    private int numberOfPlay;
    private RandomGenerator randomGenerator;

    private final int MOVE_BASE = 4;

    public Racing(String carNames, int numberOfPlay) {
        this.randomGenerator = new RandomGenerator();
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

    public void moved(int randomNumber, Car car) {
        if (randomNumber > MOVE_BASE) {
            car.moved();
        }
    }
}
