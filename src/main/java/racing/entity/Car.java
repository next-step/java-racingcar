package racing.entity;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 090df7a39 (fix: 테스트 수정)
import java.util.Random;

public class Car {

    private final String name;
    private int position;
    private final Random random = new Random();

    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (canMove()) {
            position += 1;
        }
    }

    private boolean canMove() {
        int randomValue = random.nextInt(RANDOM_RANGE);
        return randomValue >= MOVE_THRESHOLD;
    }
}


<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======

>>>>>>> 090df7a39 (fix: 테스트 수정)
