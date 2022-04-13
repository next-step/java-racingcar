package racingcar_step3;

public class ResultView {


    public static void showState(int carNum, int[] cars) {
        for (int i = 0; i < carNum; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cars[i]; j++) {
                sb.append('-');
            }
            System.out.println(sb.toString());
        }
        System.out.println("");
    }
}
