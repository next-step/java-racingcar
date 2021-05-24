package racing;

import java.util.*;

public class Racing {
    private Players players;
    private PrintResult printResult;
    private int numberOfPlay;
    private RandomGenerator randomGenerator;

    public Racing(String carNames, int numberOfPlay) {
        this.randomGenerator = new RandomGenerator();
        this.printResult = new PrintResult();
        this.players = new Players(carNames);
        this.numberOfPlay = numberOfPlay;
    }

    public Racing(List<Car> cars) {
        this.players = new Players(cars);
    }

    public List<String> race() {
        for (int play = 0; play < numberOfPlay; play++) {
            game();
        }

        return printResult.setWinner(players);
    }

    public void game() {
        for (Car car : players.getCars()) {
            car.moved(randomGenerator.create());
            printResult.printPlayers(car);
        }
    }
}
