package step3;

public class Drawing {

    public void drawCarRacing(int[] positions, int numOfCar) {
        for (int i=0; i<numOfCar; i++) {
            drawCarPosition(positions[i]);
            System.out.println();
        }
    }

    private void drawCarPosition(int position) {
        for (int i=0; i<position; i++) {
            System.out.print("-");
        }
    }
}
