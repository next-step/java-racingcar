package step3;

public class GameRunner {
    public static void main(String[] args) {
        EnterGameConfig enterGameConfig = new EnterGameConfig();

        Racing racing = new Racing(enterGameConfig.participantNumber, enterGameConfig.iterate);
        racing.start();

        ResultPrinter resultView = new ResultPrinter();
        resultView.print(enterGameConfig.iterate, racing.getParticipantsRecord());
    }
}
