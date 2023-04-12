package step3;

public class Car {
    int steps;

    //테스트용 객체 Getter
    public int getSteps() {
        return steps;
    }

    Car() {
        this.steps = 0;
    }

    public void isCarMove(int randNumber) {
        if (randNumber >= 4 && randNumber < 10) {
            this.steps++;
        }
    }
}
