package step3.domain;

public class NotMoveStrategy implements MoveStrategy {

    @Override
    public boolean move(int condition) {
        return false;
    }
}
