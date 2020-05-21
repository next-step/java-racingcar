package me.daeho.step3;

import me.daeho.step3.rule.DefaultForwardRule;
import me.daeho.step3.rule.ForwardRule;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private int firstGradePosition;
    private int time;
    private List<Car> cars;

    private RacingGame(List<Car> cars, int time) {
        this.cars = cars;
        this.time = time;
    }

    public static RacingGame init(ForwardRule forwardRule, String[] carNames, int time) {
        return new RacingGame(readyCars(forwardRule, carNames), time);
    }

    private static List<Car> readyCars(ForwardRule forwardRule, String[] carNames) {
        return new ArrayList<Car>(){{
            Arrays.stream(carNames).forEach(name -> add(Car.ready(forwardRule, name)));
        }};
    }

    public List<Car> move() {
        cars.forEach(car -> setFirstGradePosition(car.move()));
        time --;
        return cars;
    }

    public boolean hasNext() {
        return time > 0;
    }

    public List<Car> winningCars() {
        return cars.stream().filter(car -> car.getCurrentPosition() == firstGradePosition).collect(Collectors.toList());
    }

    private boolean isFirstGrade(int position) {
        return position > firstGradePosition;
    }

    private void setFirstGradePosition(int position) {
        if(isFirstGrade(position))
            firstGradePosition = position;
    }
}

