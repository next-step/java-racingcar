package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time= 0;
    private int carNumbers = 0;
    private int round = 0;
    private List<Round> roundInfos;


    private RacingGame(int time, int carNumbers) {
        this.time = time;
        this.carNumbers = carNumbers;
    }

    public int showEnterCarNumbers(){
        return this.carNumbers;
    }

    public int showTryTimes(){
        return this.time;
    }

    public Round showCarPositions(int round) {
        return this.roundInfos.get(round);
    }

    public List<Car> move(int round){
        this.round = round;
        List<Car> result = new ArrayList<>();
        result.add(new Car());

        return result;
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "time=" + time +
                ", carNumbers=" + carNumbers +
                ", roundInfos=" + roundInfos.get(round) +
                '}';
    }

    public static class RacingGameBuilder{
        private int time= 0;
        private int carNumbers = 0;

        public RacingGameBuilder setCarNumbers(int carNumbers) {
            this.carNumbers = carNumbers;
            return this;
        }

        public RacingGameBuilder setTime(int time){
            this.time = time;
            return this;
        }

        public RacingGame build(){
            return new RacingGame(time,carNumbers);
        }
    }
}
