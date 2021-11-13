package step3;

public class Car {
    public int location = 0;

    public void play(InputMovingStrategy inputMovingStrategy) {
        Boolean moved = inputMovingStrategy.run();
        if (moved) {
            location++;
        }
    }
}
