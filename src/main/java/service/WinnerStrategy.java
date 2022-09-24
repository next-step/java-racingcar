package service;

import model.Car;

import java.util.List;

@FunctionalInterface
public interface WinnerStrategy {

    List<Car> pickWinner(List<Car> candidates);
}
