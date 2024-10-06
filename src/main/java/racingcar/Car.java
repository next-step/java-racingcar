package racingcar;


public class Car {

    private int position = 0;
    private String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
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
