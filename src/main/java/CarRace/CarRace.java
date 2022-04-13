package CarRace;

import java.util.*;

public class CarRace {
    int numberOfCars;
    int numberOfRaces;
    List<List<Integer>> raceInfoBoard;

    public CarRace() {}

    public CarRace(int numberOfCars, int numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
        this.raceInfoBoard = new ArrayList<>();
    }

    public void inputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.numberOfRaces = scanner.nextInt();

        this.raceInfoBoard = new ArrayList<>();
    }

    public void startRace() {
        for(int i = 0; i < this.numberOfRaces; i++) {
            raceInfoBoard.add(new ArrayList<>());
            for(int j = 0; j < this.numberOfCars; j++) {
                raceInfoBoard.get(i).add(resultOfEachCarRacing());
            }
        }
    }

    private Integer resultOfEachCarRacing() {
        int result = 0;
        for (int i = 0; i < this.numberOfRaces; i++) {
            result += goIfMoreThanFour(getRandomNumberBetweenZeroAndNine());
        }

        return result;
    }

    public int getRandomNumberBetweenZeroAndNine() {
        return new Random().nextInt() % 10;
    }

    public int goIfMoreThanFour(int number) {
        return number >= 4 ? 1 : 0;
    }
}
