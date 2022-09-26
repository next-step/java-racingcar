package racingcar.domain;

public class Car {

    private static final int RUNNABLE_BOUND = 4;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int distance;
    private Randomable randomable;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.distance = 0;
        this.randomable = new RandomNumber();
    }

    public Car(String name,Randomable randomable) {
        validateCarName(name);
        this.name = name;
        this.distance = 0;
        this.randomable = randomable;
    }

    public Car(Randomable randomable) {
        this.distance = 0;
        this.randomable = randomable;
    }

    public void run() {
        if (isRunnable()) {
            this.distance += 1;
        }
    }

    public int showDistance() {
        return this.distance;
    }

    public String showName() {
        return name;
    }

    private boolean isRunnable() {
        return RUNNABLE_BOUND <= randomable.getIntInRange(MIN_VALUE, MAX_VALUE);
    }

    private void validateCarName(String name) {

        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        if (name.contains(" ")){
            throw new IllegalArgumentException("자동차 이름은 공백이 포함될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
