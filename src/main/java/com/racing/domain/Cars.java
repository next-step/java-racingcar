package com.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
