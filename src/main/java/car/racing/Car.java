package car.racing;

public class Car {

    private static final int NAME_LIMIT = 5;

    private int forwardCount;
    private String name;

    public Car(String name, int forwardCount) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("이름 길이가 너무 기네요ㅠ");
        }
        this.name = name;
        this.forwardCount = forwardCount;
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
