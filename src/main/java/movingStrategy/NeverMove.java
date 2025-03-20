package movingStrategy;

public class NeverMove implements Moveable{
    @Override
    public Boolean isMoveable() {
        return false;
    }
}
