package racing;

import java.util.Random;

public class Strategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;

    public boolean isMovable = false;

    public void setMovable(){
        Random random = new Random();
        isMovable = random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD;
    }

    public void setMovable(boolean move){
        isMovable = move;
    }
}
