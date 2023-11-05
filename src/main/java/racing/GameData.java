package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameData {

    private final int cars;
    private final int trials;

    public GameData(int cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public static GameData userInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int trials = scanner.nextInt();

        return new GameData(cars, trials);
    }

    public List<Integer> inputData() {

        List<Integer> data = new ArrayList<>();
        data.add(cars);
        data.add(trials);

        return data;
    }
}
