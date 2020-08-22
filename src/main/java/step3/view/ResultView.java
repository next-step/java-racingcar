package step3.view;

import step3.operation.Operation;

public class ResultView {

    public void showToMove(int game) {
        for(int z = 0 ; z < game ; z++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void viewProgress(int numOfAtp, int numOfCars) {
        Operation operation = new Operation();
        int[] game = new int[numOfCars];
        for(int i = 0; i < numOfAtp ; i++) {
            int[] result = operation.makeRandomValue(numOfCars);
            operation.progress(game, result);
            System.out.println();
        }
    }
}
