package step3.car;

import step3.generator.GenerateNumberStrategy;

public class Car {

    private int position;

    public int move(GenerateNumberStrategy generateNumberStrategy) {
        if (generateNumberStrategy.isMove()) {
            this.position++;
        }

        return position;
    }
}
