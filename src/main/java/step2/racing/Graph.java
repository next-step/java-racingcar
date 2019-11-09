package step2.racing;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private String carModel;
    private List<String> scores;

    private Graph(String carModel) {
        this.carModel = carModel;
        this.scores = new ArrayList<>();
    }

    public static List<Graph> createList(List<Car> cars) {
        List<Graph> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new Graph(car.getModel()));
        }
        return result;
    }

    public void addScore(String scoreGraph) {
        scores.add(scoreGraph);
    }

    public String draw(int turn) {
        return carModel + " : " + scores.get(turn);
    }

    public void addWinner(List<String> winners, int max) {
        if (isWinner(max)) {
            winners.add(carModel);
        }
    }

    public int getFinalScore() {
        return getScore(scores.size() - 1);
    }

    private boolean isWinner(int max) {
        return getFinalScore() == max;
    }

    private int getScore(int turn) {
        return scores.get(turn).length();
    }

}
