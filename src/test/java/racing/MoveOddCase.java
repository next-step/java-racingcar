package racing;

public class MoveOddCase implements MoveStrategy {

    private int number = 0;

    @Override
    public Boolean isMove() {
        return number++ % 2 == 0;
    }
}
