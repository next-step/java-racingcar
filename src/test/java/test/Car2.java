package test;

import java.util.Random;
import org.assertj.core.internal.RealNumbers;
import org.junit.jupiter.params.ParameterizedTest;

public class Car2 {
    private static final int MAXINUM_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;
    private final String name;
    private int position;

    public Car2(final String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car2(final String name, final int position) {
        if (name.length() > MAXINUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final int condition) {
        if (condition >= 4) {
            position++;
        }
    }
//
//    protected int getRandomNumber() {
//        return new Random().nextInt(10); //0~9까지 랜덤이면 9가 아니라 10
//    }
}
