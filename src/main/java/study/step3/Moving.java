package study.step3;
/*
* 운송 수단에 대한 전략 설정 클래스
* */
public class Moving {
    private MoveStrategy moveStrategy;

    public void move(){
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
