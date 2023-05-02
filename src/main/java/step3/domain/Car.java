package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int NAME_LENGTH = 5;

    private String name;
    private int goCount;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int goCount) {
        checkName(name);
        this.name = name;
        this.goCount = goCount;
    }

    public String getName() {
        return name;
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
