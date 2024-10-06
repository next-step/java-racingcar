package racingcar;


public class Car {

    private int position = 0;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int getPosition() {
        return this.position;
    }

    public void run() {
        if (moveStrategy.isMove()) {
            this.position++;
        }
    }

    public String getStatus(String symbol) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < position; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

}
