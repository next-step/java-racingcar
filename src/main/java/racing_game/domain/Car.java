package racing_game.domain;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name) {
        validation(name);
        this.name = name;
        this.moveCount = 0;
    }

    public void tryMove(int number){
        if(4 < number){
            moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int max){
        return moveCount == max;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void validation(String name){
        emptyName(name);
        maxLength(name);
    }

    private void maxLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
    private void emptyName(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }
}
