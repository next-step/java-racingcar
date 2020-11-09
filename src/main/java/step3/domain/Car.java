package step3.domain;

import step3.util.Validator;

/**
 * Created By mand2 on 2020-11-04.
 * 자동차 객체
 */
public class Car {

    private final String name;
    private int step; //자동차가 전진한 횟수
    private final int MAXIMUM_CAR_NAME_LENGTH = 5;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int step) {
        Validator.checkEmpty(name);
        Validator.checkLength(name, MAXIMUM_CAR_NAME_LENGTH);

        this.name = name;
        this.step = step;
    }


    public void forward(int step) {
        this.step = this.step + step;
    }

    public int getStep() {
        return this.step;
    }

    public String getName() {
        return name;
    }
}
