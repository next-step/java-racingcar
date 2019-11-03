package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final static int ZERO = 0;
    private String name;
    private List<Integer> position;
    private boolean winner;

    public Car(String name) {
        this.name = name;
        this.position = new ArrayList<>();
        this.winner = false;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPosition() {
        return this.position;
    }

    public int currentPosition() {
        int sum = 0;
        for (Integer integer : position) {
            sum += integer;
        }
        return sum;
    }

    public boolean isWinner() {
        return winner;
    }

    public void updatePosition(int movePosition) {
        this.position.add(movePosition);
    }

    public void updateWinner(int position) {
        if (currentPosition() == position) {
            winner = true;
        }
    }
}