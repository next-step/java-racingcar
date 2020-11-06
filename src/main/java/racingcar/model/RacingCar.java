package racingcar.model;

public class RacingCar {

    private int targetPoint;
    private int currentPosition;
    private Commander commander;

    public RacingCar(Commander commander) {
        this.commander = commander;
        this.targetPoint++;
    }

    public void executeMoveTrack() {
        if(commander.moveForward()){
            targetPoint ++;
        }
    }

    public int movePosition() {
        if(isReachMoveTargetPosition()) {
            return targetPoint;
        }
        currentPosition++;
        return currentPosition;
    }


    private boolean isReachMoveTargetPosition() {
        return currentPosition == targetPoint ? true : false;
    }
}
