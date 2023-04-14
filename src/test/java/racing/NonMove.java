package racing;

public class NonMove implements MoveStrategy {

    @Override
    public Boolean isMove() {
        return Boolean.FALSE;
    }

}
