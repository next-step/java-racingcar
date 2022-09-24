import java.util.List;

public class ResultView {

    private final int cars;
    private final int attempts;
    private List<Integer> accumulatedList;
    private final CarPlay carPlay;

    public ResultView(CarPlay carPlay, InputReview inputReview) {
        this.cars = inputReview.getCars();
        this.carPlay = carPlay;
        this.attempts = inputReview.getAttempts();
    }

    public void printTotalCarStatus() {
        for (int i = 0; i < attempts; i++) {
            setPrintCarStatus();
            if (checkLastAttempt(i, attempts))
                System.out.println();
        }
    }

    private void setPrintCarStatus() {

        List<Integer> updatedCarList = updateCarList();
        for (int i = 0; i < cars; i++) {
            for (int j = 0; j < updatedCarList.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private List<Integer> updateCarList() {

        List<Integer> randomCarList = carPlay.carMovement();

        if (checkAccumulatedListNull(this.accumulatedList)) {
            this.accumulatedList = randomCarList;
            return this.accumulatedList;
        }

        for (int i = 0; i < cars; i++) {
            if (randomCarList.get(i) != 0) {
                this.accumulatedList.set(i, accumulatedList.get(i) + 1);
            }
        }
        return this.accumulatedList;
    }

    private boolean checkAccumulatedListNull(List<Integer> checkList) {
        return checkList == null;
    }

    private boolean checkLastAttempt(int idx, int attempts) {
        return idx != attempts - 1;
    }
}
