package step4;

public class RandomMovable implements Movable {
    @Override
    public boolean move() {
        return RandomMoveDeterminator.doMoving();
    }

}
