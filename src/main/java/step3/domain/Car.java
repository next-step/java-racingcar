package step3.domain;

/**
 * Created By mand2 on 2020-11-04.
 * 자동차 객체
 */
public class Car {

    private int step; //자동차가 전진한 횟수

    public Car() {
        this.step = 0;
    }

    public Car(int step) {
        this.step = step;
    }

    public void forward() {
        this.forward(1);
    }

    public void forward(int step) {
        this.step = this.step + step;
    }

    public int getStep() {
        return this.step;
    }
}
