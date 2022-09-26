package step3.service;

public class ResultView {

    private final CarPlay carPlay;

    public ResultView(CarPlay carPlay) {
        this.carPlay = carPlay;
    }

    public void printTotalCarStatus(InputView inputView) {
        for (int i = 0; i < inputView.getAttempts(); i++) {
            carPlay.convertCarStatusToPrint(inputView);
            if (checkLastAttempt(i, inputView.getAttempts()))
                System.out.println();
        }
    }

    private boolean checkLastAttempt(int idx, int attempts) {
        return idx != attempts - 1;
    }
}
