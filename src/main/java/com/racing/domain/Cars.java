package com.racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> items;

    public Cars() {
        items = new ArrayList<>();
    }

    public Cars(List<Car> carList) {
        this.items = carList;
    }

    public void addCars(Car car) {
        items.add(car);
    }

    public List<Car> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.items) {
            maxPosition = car.isDefeated(maxPosition) ? maxPosition : car.getPosition();
        }

        return maxPosition;
    }

    public Cars determineWinners() {
        int maxPosition = this.findMaxPosition();

        List<Car> winnerList = this.items.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Cars(winnerList);
    }

    public int carsSize() {
        return this.items.size();
    }

    public String getCarName(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Invalid car index");
        }

        return items.get(index).displayCarName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(items, cars.items);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(items);
    }
}
