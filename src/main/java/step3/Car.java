package step3;

public class Car {

    private int currentPosition;

    public Car() {
        // TODO: 움직일지 안움직일지 결정하는 객체 주입
    }

    public void move() {
        // TODO: 주입 받은 객체로 결과를 받은 후 움직이도록
        currentPosition += 1;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
