package carrace;

import java.util.*;

public class CarRace {
    private int numberOfCars;
    private int numberOfRaces;
    private List<Integer> raceInfoBoards;

    private static final Random random = new Random();

    public CarRace() {
    }

    public CarRace(int numberOfCars, int numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
        this.raceInfoBoards = new ArrayList<>();
    }

    public void startRaces() {
        for (int i = 0; i < this.numberOfRaces; i++) {
            startEachRace();
        }
    }

    private void startEachRace() {
        for (int j = 0; j < this.numberOfCars; j++) {
            this.raceInfoBoards.add(resultOfEachCarRacing());
        }
    }
    
    private int resultOfEachCarRacing() {
        int result = 0;
        for (int i = 0; i < this.numberOfRaces; i++) {
            result += goIfMoreThanDecisionValue();
        }

        return result;
    }

    public int goIfMoreThanDecisionValue() {
        return isMoreThanDecisionValue() ? CarRaceRule.GO.getValue() : CarRaceRule.STOP.getValue();
    }

    public boolean isMoreThanDecisionValue() {
        return getRandomNumberBetweenZeroAndNine() >= CarRaceRule.DECISION_VALUE.getValue();
    }

    public int getRandomNumberBetweenZeroAndNine() {
        return (random.nextInt() & Integer.MAX_VALUE) % 10;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    public List<Integer> getRaceInfoBoards() {
        return raceInfoBoards;
    }

    public void setRaceInfoBoards(List<Integer> raceInfoBoards) {
        this.raceInfoBoards = raceInfoBoards;
    }
}
