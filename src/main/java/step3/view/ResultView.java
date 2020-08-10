package step3.view;

import step3.model.Car;

public class ResultView {
    public static void resultShow(int[][] result){
        for(int i=0; i< result.length;i++){
            for(int k=0; k< result[i].length;k++){
                int record = result[i][k];

                System.out.println("");
                for(int l = 0; l < record; l++){
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
        System.out.println();
    }
}
