package racinggame.carVo;

public class Car {
    private StringBuilder countMoving;        // 이동한 거리

    public Car() {
        countMoving = new StringBuilder("-");
    }

    public StringBuilder getCountMoving() {
        return countMoving;
    }

    public void setCountMoving(StringBuilder countMoving) {
        this.countMoving = countMoving;
    }
}
