package study.step4;

import java.util.Random;

public class Car {
    String name;
    int score = 0;

    public Car(String name) {
        this.name = name;
    }
    /* 1~10 사이 랜덤숫자 추출 */
    public int randomNumber () {
        Random random = new Random();
        return random.nextInt(10);
    }
    /* 전진 여부 로직 */
    public void go (int number) {
        if (number >= 4) {
            ResultView.printForwardLine();
            this.score++;
        }
    }
}
