package step3;

public class Car {
    public int location = 0;

    public void play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        location++;
    }
}
