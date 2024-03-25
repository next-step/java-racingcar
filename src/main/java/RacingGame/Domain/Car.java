package RacingGame.Domain;

public class Car {
    private int move = 0;
    private String name;
    private RandomNumberStrategy strategy;

    public Car(String str) {
        name = str;
    }

    public void setStrategy(RandomNumberStrategy randomNumberStrategy) {
        this.strategy = randomNumberStrategy;
    }

    public void moveForward() {
        if (strategy.generateRandomNumber() >= 4) move++;
    }

    public int getMoveInfo() {
        return move;
    }

    public String getName() {
        return name;
    }
}
