package racingcar.domain;

public class RandomStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("RandomStrategy.move");
    }
}
