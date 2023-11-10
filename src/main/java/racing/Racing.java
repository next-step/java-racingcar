package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> participants;
    private int round;
    private int longestDistance;
    private List<String> winners;

    public Racing(int cars, int round) {
        this.participants = new ArrayList<>();
        for (int i=0; i<cars; i++) {
            participants.add(new Car());
        }
        this.round = round;
        this.longestDistance = 0;
        this.winners = new ArrayList<>();
    }

    public Racing(String[] carNames, int round) {
        this.participants = new ArrayList<>();
        for (int i=0; i<carNames.length; i++) {
            Car car = new Car(carNames[i]);
            participants.add(car);
        }
        this.round = round;
        this.longestDistance = 0;
        this.winners = new ArrayList<>();
    }

    public int getLongestDistance() {
        return longestDistance;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void race() {
        for (int i=0; i<round; i++) {
            updateCar();
            ResultView.print("");
        }
    }

    public void race(List<Integer> distanceList) {
        for (int i=0; i<round; i++) {
            updateCar(distanceList);
            ResultView.print("");
        }
    }

    private void updateCar() {
        for (Car participant : participants) {
            participant.move();
            participant.showDistance();
        }
    }

    private void updateCar(List<Integer> distanceList) {
        for (int i=0; i<participants.size(); i++) {
            participants.get(i).move(distanceList.get(i));
            participants.get(i).showDistance();
        }
    }

    public void showWinner() {
        findLongestDistance();
        StringBuilder winnerNames = new StringBuilder();
        for (Car participant : participants) {
            findWinner(participant);
        }
        for (String winner : winners) {
            winnerNames.append(winner + ", ");
        }
        winnerNames.delete(winnerNames.length()-2, winnerNames.length());
        ResultView.print(winnerNames + "가 최종 우승했습니다.");
    }

    private void findWinner(Car participant) {
        if (longestDistance == participant.getDistance()) {
            winners.add(participant.getName());
        }
    }

    private void findLongestDistance() {
        for (Car participant : participants) {
            longestDistance = Math.max(longestDistance, participant.getDistance());
        }
    }
}
