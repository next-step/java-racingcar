package racing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Car {
    private static final int MIN_NUM = 4;

    private String name;
    private Integer position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }


    /**
     * 차 움직이기
     */
    public void move(int num) {
        if (canMove(num)) {
            this.position++;
        }
    }

    /**
     * 움직일 수 있는지. 움직일 수 있으면 return 1
     *
     * @param num
     * @return
     */
    private boolean canMove(int num) {
        return num >= MIN_NUM;
    }


    /**
     * 가장 멀리있는가?
     *
     * @param cars
     * @return
     */
    public boolean isMaxPosition(Integer maxPosition) {
        return position.intValue() == maxPosition.intValue();
    }


}
