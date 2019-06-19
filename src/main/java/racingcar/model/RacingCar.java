package racingcar.model;

import racingcar.logic.CarEngine;

public class RacingCar implements Comparable<RacingCar>{
    private String name;
    private Integer position;
    private CarEngine carEngine;

    private RacingCar(String name, Integer position, CarEngine carEngine) {
        this.name = name;
        this.position = position;
        this.carEngine = carEngine;
    }

    public static RacingCar of(String name, CarEngine carEngine) {
        return new RacingCar(name, 0, carEngine);
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public RacingCar tryMove() {
        if (carEngine.isMove()) {
            position += 1;
        }
        return this;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(position, o.position);
    }
}