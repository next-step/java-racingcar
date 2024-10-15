package com.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void addCars(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.carList) {
            maxPosition = car.isDefeated(maxPosition) ? maxPosition : car.getPosition();
        }

        return maxPosition;
    }

    public Cars determineWinners() {
        int maxPosition = this.findMaxPosition();

        List<Car> winnerList = this.carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Cars(winnerList);
    }

    public int carsSize() {
        return this.carList.size();
    }

    public String getCarName(int index) {
        if (index < 0 || index >= carList.size()) {
            throw new IndexOutOfBoundsException("Invalid car index");
        }

        return carList.get(index).displayCarName();
    }

    public void printRacingPositions() {
        for (Car car : carList) {
            System.out.println(car.displayRacingPosition());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(carList, cars.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carList);
    }
}
