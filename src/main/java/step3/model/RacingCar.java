package step3.model;

public class RacingCar {

    private int moveTrack;
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

}
