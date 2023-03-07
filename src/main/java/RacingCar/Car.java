package RacingCar;

import java.util.Random;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;

    public String name;
    public int move;


    public Car(String name){
        this(name, DEFAULT_POSITION);
        validatename(name);
    }

    public Car(String name, int move) {

        validatename(name);
        this.name = name;
        this.move = move;

    }

    public void Move(int movecnt) {
        if(movecnt > 4)
            move ++;
    }

    public int randomcnt() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void validatename(String name)
    {
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 한다.");

        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
