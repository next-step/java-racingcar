package car;

import java.util.ArrayList;
import java.util.List;

public class WinnerCar implements Car {
    private String name;
    private List<Boolean> distance;
    private MovableStrategy movableStrategy;

    private static final int MAX_LENGTH = 5;

    public WinnerCar(MovableStrategy movableStrategy) {
        this.distance = new ArrayList<>();
        this.movableStrategy = movableStrategy;
    }

    @Override
    public void racing() {

    }

    @Override
    public String printResult() {
        return null;
    }

    public void inputName(String name) {
        checkNameLength(name.length());
        this.name = name;
    }

    private void checkNameLength(int len) {
        if(MAX_LENGTH < len) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
