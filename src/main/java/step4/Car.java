package step4;

public class Car {
    private static final int RANDOM_LIMIT = 4;

    private String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public Car(Car car) {
        this.name = car.name;
        this.progress = car.progress;
    }

    public static Car of(Car car) {
        return new Car(car);
    }

    public void move(int random) {
        if (movable(random)) {
            progress++;
        }
    }

    public void moveCar(int value) {
        progress += value;
    }

    public static boolean movable(int random) {
        return random >= RANDOM_LIMIT;
    }

    public boolean isEqualsProgress(int progress) {
        return this.progress == progress;
    }

    public int getBigerProgress(int progress) {
        return Math.max(progress, this.progress);
    }

    public String getName() {
        return name;
    }

    public String getProgressByCharacter(String character) {
        return character.repeat(progress);
    }

}
