import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 4;
    private int position;


//    public int move() {
//        if (canMove()) position++;
//        return position;
//    }

//    private boolean canMove() {
//        return random.nextInt(10) >= MOVE_THRESHOLD;
//    }

    public int move() {
        int randomValue = random.nextInt(10);
        return move(randomValue);
    }

    public int move(int random) {
        if(random >= MOVE_THRESHOLD) position++;
        return position;
    }

    public int getPosition() {
        return this.position;
    }

}
