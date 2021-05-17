package racing;

import java.util.*;

public class Racing {
    private Players players;
    private PrintResult printResult;
    private int numberOfPlay;
    private Random random;

    public Racing(String carNames, int numberOfPlay) {
        this.printResult = new PrintResult();
        this.players = new Players(carNames);
        this.numberOfPlay = numberOfPlay;
        random = new Random();
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
            moved(random.nextInt(10), car);
            System.out.print(car.getName() + " : ");
            printResult.printTrace(car);
            System.out.println();
        }
    }
    /*
    public void random(int mustMove) {
        int count = 0;
        for(Car car: cars) {
            moved(mustMove + count, car);
            System.out.println(car.getName() + " : ");
            printTrace(car);
            System.out.println();
            count++;
        }
    }
     */

    public void moved(int random, Car car) {
        if (random > 4) car.moved();
    }
}
