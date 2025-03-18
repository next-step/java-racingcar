package carrace.common;

public interface Move {

    // 현 과제에서는 앞으로의 이동만 고려
    void moveForward();

    // TODO: 움직이지 않음
    void stop();

    // TODO: 뒤로 이동이 있다면.
    void moveBackward();

    // TODO: 좌로 이동이 있다면.
    void moveLeft();

    // TODO: 우로 이동이 있다면.
    void moveRight();
}
