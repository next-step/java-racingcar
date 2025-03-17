package racingcar;


import java.util.Random;

public class Car {

    public static final Random RANDOM = new Random();
    private static final int MOVE_PROBABILITY = 4;
    private static final int TOTAL_PROBABILITY = 10;
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private Integer distance = 0;
    private Integer playCount = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    // test용 생성자
    protected Car(String name, Integer distance, Integer playCount) {
        validateName(name);
        this.name = name;
        this.distance = distance < 0 ? 0 : distance;
        this.playCount = playCount < 0 ? 0 : playCount;
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d자 이하여야 합니다.", MAX_NAME_LENGTH));
        }
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public Integer play() {
        playCount++;
        if (moveForwardOrNot()) {
            distance++;
        }
        return getDistance();
    }

    private static boolean moveForwardOrNot() {
        return RANDOM.nextInt(TOTAL_PROBABILITY) >= MOVE_PROBABILITY;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
