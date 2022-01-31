package racing;

public class RacingApplication {

    public static void main(String[] args) {
        RacingInfo info = RacingInfo.init();

        Racing racing = new Racing(info);
        racing.race();

        Judgement judgement = new Judgement(racing.getLastResult());
        System.out.println("최종우승자: " + String.join(", ", judgement.judgeWinner()));
    }
}
