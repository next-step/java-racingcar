package step3.view;

import step3.operation.Operation;

public class ResultView {
    public static final String DELIMETER = "-";

    public void showToMove(int game) {
        StringBuilder sb = new StringBuilder();
        sb.append(DELIMETER);
        for (int z = 0; z < game; z++) {
            sb.append(DELIMETER);
        }
        System.out.println(sb.toString());
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
