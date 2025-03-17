import java.util.Random;

public class Car {
    private int distance;
    private final Random random;

    public Car(){
        this.distance = 0;
        this.random  = new Random();
    }

    public void move(){
        if(isMove(generateRandomNumber())) distance++;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public int generateRandomNumber(){
        return random.nextInt(10);
    }

    public String showDistance(){
        return "-".repeat(distance);
    }
}
