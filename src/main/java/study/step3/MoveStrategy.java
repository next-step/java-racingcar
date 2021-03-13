package study.step3;
/*
* 운송수단의 움직임에 대한 전략 interface
* 여러가지 다른 전략들이 생길 수 있음!!
* */
public interface MoveStrategy {
    boolean isMove(int condition);
}
