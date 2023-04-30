package racing.domain.move;

public class NonMove implements MoveStrategy {

    @Override
    public Boolean isMove() {
        return Boolean.FALSE;
    }

}
