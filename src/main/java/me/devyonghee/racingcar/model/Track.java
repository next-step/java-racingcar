package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class Track {

    private static final Distance MOVEMENT_DISTANCE = Distance.ONE;
    private static final Distance STOP_DISTANCE = Distance.ZERO;

    private final RacingCar car;
    private final Distance distance;

    private Track(RacingCar car, Distance distance) {
        Assert.notNull(car, "'car' must not be null");
        Assert.notNull(distance, "'distance' must not be null");
        this.car = car;
        this.distance = distance;
    }

    public static Track of(RacingCar car, Distance distance) {
        return new Track(car, distance);
    }

    public RacingCar car() {
        return car;
    }

    public Distance distance() {
        return distance;
    }

    Track movedTrack() {
        if (car.movement() == Movement.MOVE) {
            return of(car, distance.add(MOVEMENT_DISTANCE));
        }
        return of(car, distance.add(STOP_DISTANCE));
    }

    @Override
    public String toString() {
        return "Track{" +
                "car=" + car +
                ", distance=" + distance +
                '}';
    }
}
