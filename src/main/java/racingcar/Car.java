package racingcar;


public class Car {

    private int position = 0;
    private String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
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
