package study.step4;

public class Car {
    String name;
    int score = 0;

    public Car(String name) {
        this.name = name;
    }

    /* 전진 여부 로직 */
    public void go (int number) {
        if (number >= 4) {
            ResultView.printForwardLine();
            this.score++;
        }
    }
}
