package racing.domain.car;

public class TestCarMoveBehavior implements CarMoveBehavior{
    private final boolean GO = true;
    private final boolean STOP = false;

    @Override
    public boolean action(){
        return GO;
    }

    public boolean stop(){
        return STOP;
    }
}
