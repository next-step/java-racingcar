package CarRace;

import java.util.*;

public class CarRace {
    int numberOfCars;
    int numberOfRaces;
    List<List<Integer>> raceInfoBoard;

    public CarRace() {}

    public void inputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.numberOfRaces = scanner.nextInt();

        this.raceInfoBoard = new ArrayList<>();
    }
}
