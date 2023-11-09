package racing.model;

import java.util.Random;

public class RacingCar {
    public static final int CAN_I_MOVE = 4;

    private final Random random = new Random();
    private int progress;
    private String name;

    public RacingCar(int progress, String name) throws IllegalAccessException {
        this.progress = progress;
        this.name = name;
        if (name.length() >= 6) {
            throw new IllegalAccessException("이름은 최대 5글자 입니다.");
        }
    }

    public void race(int randomValue) {
        if (notMovable(randomValue)) {
            return;
        }
        this.progress++;
    }

    private boolean notMovable(int randomValue) {
        return randomValue < CAN_I_MOVE;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getName() {
        return this.name;
    }

    public int getRandomInt() {
        return random.nextInt(10);
    }
    public boolean isSameProgress(int progress){
        return this.progress == progress;
    }
}
