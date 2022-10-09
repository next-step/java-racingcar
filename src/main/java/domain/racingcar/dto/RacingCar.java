package domain.racingcar.dto;

public class RacingCar {
    private final RacingCarInfo racingCarInfo;

    public RacingCar(int distance) {
        racingCarInfo = new RacingCarInfo(distance);
    }

    public RacingCar(int distance, String name) {
        if (name.length() > 5) throw new IllegalStateException("이름은 5자를 넘길 수 없습니다.");

        racingCarInfo = new RacingCarInfo(distance, name);
    }

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.checkIfMoveOrNot()) return racingCarInfo.plusDistance();
        return racingCarInfo.getDistance();
    }

    public int getDistance() {
        return racingCarInfo.getDistance();
    }

    public String getName() {
        return racingCarInfo.getName();
    }

    public boolean hasRaceWinnerDistance(int raceWinnerDistance) {
        return racingCarInfo.hasRaceWinnerDistance(raceWinnerDistance);
    }
}