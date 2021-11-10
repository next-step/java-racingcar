package racingcar;

public class Car {

    private int position = 0;

    public void action(int command) {
        if (command < 0 || command > 10) {
            throw new IllegalArgumentException("입력 값은 0~9가 와야합니다.");
        }

        if (command > 3) {
            this.position++;
        }
    }
}
