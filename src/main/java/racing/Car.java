package racing;

public class Car {
    private int NAME_MAX_LENGTH = 5;

    public String name;
    public int moveStatus;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if(name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(int moveOrStop) {
        moveStatus += moveOrStop;
    }
}
