package RacingGame.Domain;

import RacingGame.View.InputView;
import RacingGame.View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private int move = 0;
    private String name;
    private RandomNumberStrategy strategy;

    public Car(String str) {
        name = str;
    }

    public void SetStrategy(RandomNumberStrategy randomNumberStrategy) {
        this.strategy = randomNumberStrategy;
    }

    public void MoveForward() {
        if (strategy.GenerateRandomNumber() >= 4) move++;
    }

    public int GetMoveInfo() {
        return move;
    }

    public String GetName() {
        return name;
    }
}
