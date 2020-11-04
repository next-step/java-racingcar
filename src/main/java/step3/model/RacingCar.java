package step3.model;

public class RacingCar {

    private int moveTrack;
    private int currentPosition;
    private Commander commander;

    public RacingCar(Commander commander) {
        this.commander = commander;
        this.moveTrack++;
    }

    public void executeMoveTrack() {
        if(commander.moveForward()){
            moveTrack ++;
        }
    }

    public int getMoveTrack() {
        return moveTrack;
    }

    public int movePosition() {
        if(isReachMoveTargetPosition()) {
            return moveTrack;
        }
        currentPosition++;
        return currentPosition;
    }

    private boolean isReachMoveTargetPosition() {
        return currentPosition == moveTrack ? true : false;
    }
}
