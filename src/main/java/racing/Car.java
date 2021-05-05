package racing;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.moveCount++;
        }
    }

    private void validateLength(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
    }


    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
