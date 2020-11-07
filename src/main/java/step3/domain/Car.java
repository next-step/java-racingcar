package step3.domain;

import step3.util.Validator;

/**
 * Created By mand2 on 2020-11-04.
 * 자동차 객체
 */
public class Car {

    private final String name;
    private int step; //자동차가 전진한 횟수

    // TODO 생성자 name 필수조건이 되어 deprecated 시켜야 함.

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int step) {
        Validator.checkEmpty(name);

        this.name = name;
        this.step = step;
    }


    public void forward(int step) {
        this.step = this.step + step;
    }

    public int getStep() {
        return this.step;
    }
}
