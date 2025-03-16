package racingcar.ui;

public class ResultView {

    public static void viewRacingCar(int[][] moves) {
        System.out.println("실행 결과");
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                for (int k = 0; k < moves[i][j]; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
