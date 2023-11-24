package motorRace;

public class ResultView {

    private static final String RESULT_MSG = "실행 결과";

    public static void raceResultOut(RaceResult raceResult){
        System.out.println(RESULT_MSG);
        raceResult.getRaceCarPostionResultList().forEach(
                roundResult -> {
                    roundResultOut(roundResult);
                }
        );
    }

    private static void roundResultOut(RaceResult.RoundResult roundResult){
        roundResult.getRaceCarPositionList().forEach(position->{
            System.out.println("-".repeat(position));
        });
        System.out.println("");
    }
}
