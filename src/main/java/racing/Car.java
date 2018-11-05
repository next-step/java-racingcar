package racing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Car {
    private static final int MIN_NUM = 4;
    private static final int BOUND = 10;
    private Random random = SecureRandom.getInstanceStrong();
    private String name;
    private Integer position;

    public Car(String name) throws NoSuchAlgorithmException {
        this(name, 0);
    }

    public Car(String name, Integer position) throws NoSuchAlgorithmException {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 차 움직이기
     */
    public void move() {
        int randNum = random.nextInt(BOUND);
        if (canMove(randNum)) {
            this.position++;
        }
    }

    /**
     * 움직일 수 있는지. 움직일 수 있으면 return 1
     *
     * @param num
     * @return
     */
    public static boolean canMove(int num) {
        return num >= MIN_NUM;
    }
}
