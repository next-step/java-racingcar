package step3.view;

import step3.operation.Operation;

public class ResultView {

    public void resultView(int numOfAtp, int numOfCars){

        Operation op = new Operation();

        int[] game = new int[numOfCars];

        for(int i = 0; i < numOfAtp ; i++) {
            int[] result = op.makeRandomValue(numOfCars);

            for(int w = 0 ; w < game.length; w++) {
                if(result[w] >= 4) {
                    game[w] += 1;
                }
            }

            for(int j = 0 ; j < game.length; j++) {
                for(int z = 0 ; z < game[j] ; z++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
