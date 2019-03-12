package racinggame.domain;

public class Car {
    private StringBuilder viewMoving;        // 이동한 모습
    private int countMoving;                 // 이동한 거리
    private String name;                      // 차 이름

    public Car(String name) {
        this.viewMoving = new StringBuilder("-");
        this.countMoving = 0;
        this.name = name;
    }

    public StringBuilder getViewMoving() {
        return viewMoving;
    }
    public void setViewMoving(StringBuilder viewMoving) {
        this.viewMoving = viewMoving;
    }
    public String getName() {return name;}

    public void addCountMoving() {
        this.countMoving += 1;
    }
    public int getCountMoving() {
        return countMoving;
    }
}
