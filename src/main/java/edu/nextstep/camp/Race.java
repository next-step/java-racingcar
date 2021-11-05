package edu.nextstep.camp;

public class Race {
    private final int turn;
    private final int cars;

    public static Race of(int cars, int turn) {
        if (cars <= 0)
            throw new IllegalArgumentException("invalid number of cars: " + cars);

        if (turn <= 0)
            throw new IllegalArgumentException("invalid number of turns: " + turn);

        return new Race(cars, turn);
    }

    private Race(int cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public int turns() {
        return turn;
    }

    public int numberOfCars() {
        return cars;
    }
}
