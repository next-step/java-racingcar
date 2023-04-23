package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int NAME_LENGTH = 5;

    private String name;
    private int goCount;

    public Car() {
        this.goCount = 0;
    }

    public Car(String name) {
        this.name = name;
    }

    public int getGoCount() {
        return goCount;
    }

    public void addGoCount() {
        this.goCount++;
    }

    public static void checkName(String name) {
        if(name.length() > NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자를 넘길 수 없습니다.");
        }
    }

}
