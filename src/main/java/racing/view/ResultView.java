package racing.view;

public class ResultView {

    public void printPositions(int[] positions) {
        for (int position : positions) {
            printPosition(position);
        }
        printLineBreak();
    }

    private void printPosition(int position) {
        for (int p = 0 ; p < position ; p++) {
            System.out.printf("-");
        }
        printLineBreak();
    }

    private void printLineBreak() {
        System.out.println();
    }

}
