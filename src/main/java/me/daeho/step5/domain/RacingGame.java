package me.daeho.step5.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private int firstGradePosition;
    private int time;
    private Collection<Car> cars;

    private RacingGame(Collection<Car> cars, int time) {
        this.cars = cars;
        this.time = time;
    }

    public static RacingGame init(ForwardRule forwardRule, String[] carNames, int time) {
        return new RacingGame(readyCars(forwardRule, carNames), time);
    }

    public static RacingGame init(String[] carNames, int time) {
        return new RacingGame(readyCars(new DefaultForwardRule(), carNames), time);
    }

    private static Collection<Car> readyCars(ForwardRule forwardRule, String[] carNames) {
        return new ArrayList<Car>() {{
            Arrays.stream(carNames).forEach(name -> add(Car.ready(forwardRule, name)));
        }};
    }

    public Collection<Car> move() {
        cars.forEach(car -> setFirstGradePosition(car.move()));
        time--;
        return cars;
    }

    public boolean hasNext() {
        return time > 0;
    }

    public Collection<Car> winningCars() {
        return cars.stream().filter(car -> car.getCurrentPosition() == firstGradePosition).collect(Collectors.toList());
    }

    private boolean isFirstGrade(int position) {
        return position > firstGradePosition;
    }

    private void setFirstGradePosition(int position) {
        if (isFirstGrade(position))
            firstGradePosition = position;
    }
}

