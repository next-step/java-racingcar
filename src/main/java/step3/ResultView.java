package step3;


public class ResultView {

    private static String PLAY_RESULT = "실행 결과";
    private static String POSITION_OUTPUT_CHARACTER = "-";
    private static String PLAY_ROUND_INFO = "회차";

    public void printView(String line) {
        System.out.println(line);
    }

    public void printResultInfo() {
        printView(PLAY_RESULT);
    }
    public void printResult(int position) {

        StringBuilder positionOutputBuilder = new StringBuilder();

        for(int i = 0; i < position; i++) {
            positionOutputBuilder.append(POSITION_OUTPUT_CHARACTER);
        }
        printView(positionOutputBuilder.toString());
    }

    public void printRoundInfo(int roundTime) {
        StringBuilder roundOutputBuilder = new StringBuilder();

        roundOutputBuilder.append(roundTime);
        roundOutputBuilder.append(PLAY_ROUND_INFO);

        printView(roundOutputBuilder.toString());
    }


}


