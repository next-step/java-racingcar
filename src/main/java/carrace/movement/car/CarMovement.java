package carrace.movement.car;

import carrace.common.Move;

public class CarMovement implements Move {

    private String position = "-";

    // 현 과제에서는 앞으로의 이동만 고려
    public void moveForward() {
        this.position = this.position + "-";
    }

    public String get() {
        return position;
    }

    // 움직이지 않음
    public void stop() {
        // nothing
    }

    // TODO: 뒤로 이동이 생기면 추가
    public void moveBackward() {}

    // TODO: 좌로 이동이 생기면 추가
    public void moveLeft() {}

    // TODO: 우로 이동이 생기면 추가
    public void moveRight() {}
}
