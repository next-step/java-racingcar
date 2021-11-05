package carracing.view;

import carracing.CarRacing;
import carracing.RacingUtils;
import java.util.Scanner;

public class InputView {

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer carsQuantity = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer movementQuantity = scanner.nextInt();

        this.executeResultView(new CarRacing(carsQuantity, movementQuantity));
    }

    private void executeResultView(CarRacing carRacing) {
        ResultView resultView = new ResultView(carRacing);

        try {
            resultView.execute();
        } catch (InterruptedException e) {
            System.out.println(RacingUtils.INTERRUPTED_EXCEPTION);
        }
    }
}
