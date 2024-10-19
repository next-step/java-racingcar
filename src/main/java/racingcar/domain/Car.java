package racingcar.domain;


public class Car {

    private static final int NAME_MAX_LENGTH = 5;
    private int position = 0;
    private String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public Car(String name, int position, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public Car(Car car){
        this.position = car.position;
        this.name = car.name;
        this.moveStrategy = car.moveStrategy;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
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

    public boolean comparePosition(int position) {
        return this.position == position;
    }

    public int getMaxPosition(int prevPosition){
        return this.position > prevPosition ? this.position : prevPosition;
    }

}
