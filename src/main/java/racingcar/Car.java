package racingcar;

public class Car {
    private final static String MILEAGE_UNIT = "-";
    private String name; // 자동차명
    private String totalMileage; // 전진 시  주행 거래 "-" 하나 추가

    public Car(String name) {
        this.name = name;
        this.totalMileage = ""; // 주행 총 거리 초기화
    }

    public String getName() {
        return name;
    }

    public void move() {
        totalMileage += MILEAGE_UNIT;
    }

    public void stop() {

    }

    public String getTotalMileage() {
        return totalMileage;
    }
}
