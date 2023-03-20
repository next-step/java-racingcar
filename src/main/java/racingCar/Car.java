package racingCar;

import java.util.Random;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name){
        this(name, DEFAULT_POSITION);
        this.position = position;
    }

    public Car(final String name,int position){
        if(name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }


    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void move(int randomNumber){
        if(randomNumber>=4){
            this.position++;
        }
    }
}
