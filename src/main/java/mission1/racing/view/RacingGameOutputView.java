package mission1.racing.view;

public class RacingGameOutputView {
    public void resultView(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
