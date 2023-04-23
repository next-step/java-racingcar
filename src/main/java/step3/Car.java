package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {

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

}
