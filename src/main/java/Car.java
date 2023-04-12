import java.util.Random;

public class Car {
    public static final int MOVEABLE_NUMBER = 4;

    int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(10);
    }

    public boolean canMove(int number) {
        if (number >= MOVEABLE_NUMBER) {
            return true;
        }
        
        return false;
    }


}
