package step3.model;

public class GameRound {

    private int participantCar;
    private int round;
    private boolean isAllRoundFinish;

    public GameRound(int participantCar, int round) {
        this.participantCar = participantCar;
        this.round = round;
    }

    public int getParticipantCar() {
        return participantCar;
    }

    public void roundFinish() {
        this.round--;
        if(round == 0){
            isAllRoundFinish = true;
        }
    }

    public boolean isAllRoundFinish() {
        return isAllRoundFinish;
    }
}
