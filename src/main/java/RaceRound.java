public class RaceRound {
    private int round;

    private RaceRound(int round){
        if(round < 0){
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
       this.round = round;
    }
    public static RaceRound of(int round){
        return new RaceRound(round);
    }

    public int getValue(){
        return round;
    }
}
