package racing.domain.car;

public class CarStopBehavior implements CarMoveBehavior{
    private final boolean STOP = false;

    @Override
    public boolean action(){
        return STOP;
    }
}
