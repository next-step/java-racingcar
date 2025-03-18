public class Car {

    public static final int STANDARD_VALUE = 4;
    private int position;
    private String name;

    public Car(String carName) {
        this.position = 0;
        this.name = carName;
    }

    public void move() {
        // 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
        if ((int) (Math.random() * 10) >= STANDARD_VALUE) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
