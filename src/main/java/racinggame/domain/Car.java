package racinggame.domain;

public class Car {
    private int countMoving;                 // 이동한 거리
    private String name;                      // 차 이름

    public Car(String name) {
        this.countMoving = 0;
        this.name = name;
    }

    public String getName() {return name;}

    public void move() {
        this.countMoving += 1;
    }

    public int getCountMoving() {
        return countMoving;
    }

    // 승자의 이름들을 저장하는 메서드
    public boolean isWinner(int maxMovement) {
        if (getCountMoving() == maxMovement) {
            return true;
        }
        return false;
    }
}
