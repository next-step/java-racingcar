package car.racing;

public class Car {

    private static final int NAME_LIMIT = 5;

    private int forwardCount = 0;
    private String name = "";

    public Car(String name) {
        this.name = name;
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("이름 길이가 너무 기네요ㅠ");
        }
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward() {
        forwardCount++;
    }
}
