package racingcar.model;

public class Car {

    private final int SUCCESS = 4;
    private int position;
    private final String name;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position =  0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if(number >= SUCCESS)
            position++;
    }
}
