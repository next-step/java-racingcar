package study.racingcar.car;

import java.util.Random;

/**
 * 각 자동차에 대한 위치 및 이름을 보관하는 책임
 */
public class Car {

    private final CarName name;
    private int currentPosition = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(Engine engine) {

        if (engine.isMovable()) {
            goForward();
        }

    }

    private void goForward() {
        this.currentPosition += 1;
    }

    public  boolean isCurrentPosition(int position) {
        return currentPosition == position;
    }


    public <T> T export(CarExporter<T> exporter) {
        exporter.name(name.getValue());
        exporter.currentPosition(currentPosition);
        return exporter.build();
    }

}
