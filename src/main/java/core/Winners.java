package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final CurrentWinners currentWinners;

    private Winners(CurrentWinners currentWinners) {
        this.currentWinners = currentWinners;
    }

    public static Winners decideWinners(PositionBoard positionBoard) {
        CurrentWinners currentWinners = new CurrentWinners(new ArrayList<>());
        for (PositionTableKey key : positionBoard.keys()) {
            currentWinners.compare(key, positionBoard.getPositionHistory(key));
        }
        return new Winners(currentWinners);
    }

    public List<CarName> names() {
        return currentWinners.names();
    }

    public List<String> namesAsString() {
        return currentWinners.namesAsString();
    }

    public int size() {
        return currentWinners.size();
    }

    private static class CurrentWinners {
        private final List<CarName> carNames;
        private int position;

        private CurrentWinners(List<CarName> carNames) {
            this.carNames = carNames;
            this.position = 0;
        }

        public void compare(PositionTableKey key, List<Integer> positionHistory) {
            Integer LastPosition = positionHistory.get(positionHistory.size() - 1);
            if (LastPosition > position) {
                changeWinner(key, LastPosition);
                return;
            }
            if (LastPosition == position) {
                addWinner(key);
            }
        }

        public List<CarName> names() {
            return carNames;
        }

        public List<String> namesAsString() {
            return carNames.stream()
                    .map(CarName::toString)
                    .collect(Collectors.toList());
        }

        public int size() {
            return carNames.size();
        }

        private void changeWinner(PositionTableKey key, int position) {
            carNames.clear();
            carNames.add(key.getCarName());
            this.position = position;
        }

        private void addWinner(PositionTableKey key) {
            carNames.add(key.getCarName());
        }
    }
}
