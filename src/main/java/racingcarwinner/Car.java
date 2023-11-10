package racingcarwinner;

public class Car {

    private String name;
    private int location;

    public Car(final String name, final int location) {
        final int STANDARD = 5;
        if (isLengthGreaterThanStandard(name, STANDARD)) {
            System.out.println("자동차 이름은 " + STANDARD + "글자를 초과할 수 없습니다.");
            throw new IllegalStateException("자동차 이름 길이 기준 초과 오류");
        }
        this.name = name;
        this.location = location;
    }

    public static Car createDefaultCar(final String name) {
        return new Car(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public boolean isLengthGreaterThanStandard(String name, int standard) {
        return name.length() > standard;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.location++;
        }
    }

    public boolean isMaxLocation(int maxLocation) {
        return this.location == maxLocation;
    }
}
