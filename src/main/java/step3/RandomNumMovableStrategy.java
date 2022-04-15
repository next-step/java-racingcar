package step3;

public class RandomNumMovableStrategy implements MovableStrategy {

    @Override
    public boolean canMove(int num) {
        return num >= 4;
    }

}
