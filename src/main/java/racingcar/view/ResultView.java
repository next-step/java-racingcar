package racingcar.view;

public class ResultView {
    private static final String MOVEMENT = "-";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void draw(int[] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i]; j++)
                System.out.print(MOVEMENT);
            System.out.println();
        }
        System.out.println();
    }
}
