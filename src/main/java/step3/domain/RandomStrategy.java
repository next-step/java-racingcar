package step3.domain;

public class RandomStrategy implements MovableStrategy {
    @Override
    public boolean move() {
        if ((int) (Math.random() * 10) > 3) {
            return true;
        }
        return false;
    }
}
