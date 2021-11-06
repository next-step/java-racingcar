package racingcar.gameinfo;

public class RacingCarGameInfo {

    private final RacingCarGameRound round;
    private final CountInfo countInfo;

    public RacingCarGameInfo(RacingCarGameRound round, CountInfo countInfo){
        this.round = round;
        this.countInfo = countInfo;
    }

    public int getCarCount(){
        return this.countInfo.getCarCount();
    }

    public int getTryCount(){
        return this.countInfo.getTryCount();
    }

    public RacingCarGameRound getRound() {
        return this.round;
    }
}