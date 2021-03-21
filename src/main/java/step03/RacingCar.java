package step03;

public class RacingCar {

    private static int INIT_MOVE_RANGE = 0;
    private RacingCarDTO racingCarDTO;

    public RacingCar(String carName) {
        racingCarDTO = new RacingCarDTO(carName, INIT_MOVE_RANGE);
    }

    public void tryToMove(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            racingCarDTO.setMovingRange(racingCarDTO.getMovingRange() + 1);
        }
    }

    public RacingCarDTO getRacingCarData() {
        return racingCarDTO;
    }

}
