package study.step4;

public class RacingService {
    public String MESSAGE_RACING_START = "자동차 경주를 시작합니다.";
    public String MESSAGE_ROUND = "라운드";
    public String PRINT_TOKEN = "-";
    private String MESSAGE_PRINT_WINNER = "가 최종 우승하였습니다.";

    private Racing racing;

    public RacingService() {
        racing = new Racing();
    }

    public void ready(String input) {
        String[] carNames = input.split(",");
        racing.setUp(carNames);
    }

    public void play(int totalRound) {
        System.out.println(MESSAGE_RACING_START);

        for(int i=0; i<totalRound; i++) {
            System.out.println("\n" + (i+1) + MESSAGE_ROUND);
            racing.run();
            racing.printRacingResult(PRINT_TOKEN);
        }

        System.out.println("\n");
        racing.printRacingWinner(MESSAGE_PRINT_WINNER);
    }
}
