package step5;

public class RandomMovable implements Movable {
    @Override
    public boolean move() {
        return RandomMoveDeterminator.doMoving();
    }

}
