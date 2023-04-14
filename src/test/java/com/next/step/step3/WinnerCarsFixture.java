package com.next.step.step3;

import com.next.step.step3.domain.Car;

import java.util.List;

public class WinnerCarsFixture {
    public static List<Car> 한_명의_우승자_경우_CARS() {
        return List.of(
                new Car(1, "a"),
                new Car(2, "b"),
                new Car(3, "c")
        );
    }

    public static List<Car> 모두_우승한_경우_CARS() {
        return List.of(
                new Car(1, "a"),
                new Car(1, "b"),
                new Car(1, "c")
        );
    }

    public static List<Car> B_C가_우승한_경우_CARS() {
        return List.of(
                new Car(1, "a"),
                new Car(100, "b"),
                new Car(100, "c")
        );
    }
}
