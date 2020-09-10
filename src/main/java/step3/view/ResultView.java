package step3.view;

import step3.operation.Operation;

public class ResultView {
    public static final String DELIMETER = "-";

    public void showToMove(int game) {
        String str = DELIMETER;
        for (int z = 0; z < game; z++) {
            str += DELIMETER;
        }
        System.out.println(str);
    }

    public void viewProgress(int numOfAtp, int numOfCars) {
        Operation operation = new Operation();
        int[] game = new int[numOfCars];
        for (int i = 0; i < numOfAtp; i++) {
            int[] result = operation.makeRandomValue(numOfCars);
            operation.progress(game, result);
            System.out.println();
        }
    }

}
