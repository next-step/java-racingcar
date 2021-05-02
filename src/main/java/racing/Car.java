package racing;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
        this.name = name;
    }


    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
