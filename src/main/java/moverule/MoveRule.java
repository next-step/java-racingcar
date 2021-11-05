package moverule;

import car.Car;

@FunctionalInterface
public interface MoveRule {
    void move(Car car);
}
