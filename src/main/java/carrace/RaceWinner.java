package carrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceWinner {

    private List<Integer> winningBoards = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    public RaceWinner(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            this.winningBoards.add(0);
        }
    }

    public void confirmWinners(List<Integer> raceInfoBoards, List<Car> cars) {
        int numberOfCars = cars.size();
        int numberOfRaces = raceInfoBoards.size() / numberOfCars;
        List<List<Integer>> raceInfoPartitions = splitRaceInfoBoards(raceInfoBoards, numberOfCars);

        for (int i = 0; i < numberOfRaces; i++) {
            countWinnings(raceInfoPartitions.get(i));
        }

        pickWinners(cars);
    }

    private void pickWinners(List<Car> cars) {
        int maxWins = winningBoards.stream()
                .mapToInt(a -> a)
                .max()
                .orElse(0);

        AtomicInteger i = new AtomicInteger();
        winningBoards.stream().forEach(winnerIndex -> {
            if (maxWins == winnerIndex) {
                this.winners.add(cars.get(i.get()));
            }
            i.getAndIncrement();
        });
    }

    private List<List<Integer>> splitRaceInfoBoards(List<Integer> raceInfoBoards, int numberOfCars) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < raceInfoBoards.size(); i += numberOfCars) {
            result.add(raceInfoBoards.subList(i, i + numberOfCars));
        }
        return result;
    }

    private void countWinnings(List<Integer> raceInfo) {
        int maxMoves = raceInfo.stream()
                .mapToInt(a -> a)
                .max()
                .orElse(0);

        AtomicInteger i = new AtomicInteger();
        raceInfo.stream().forEach(moves -> {
            if (moves == maxMoves) {
                this.winningBoards.set(i.get(), this.winningBoards.get(i.get()) + 1);
            }
            i.getAndIncrement();
        });
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
