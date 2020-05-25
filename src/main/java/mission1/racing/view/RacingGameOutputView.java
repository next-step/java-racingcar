package mission1.racing.view;

public class RacingGameOutputView {
    public void resultView(String carName, int carPosition) {
        System.out.print(carName + ": ");

        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public void winnerView(String[] winners) {
        for(int i = 0; i < winners.length - 1; i++) {
            System.out.print(winners[i] + ", ");
        }

        System.out.print(winners[winners.length - 1] + "가 최종 우승했습니다.");
    }
}
