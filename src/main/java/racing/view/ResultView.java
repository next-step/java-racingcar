package racing.view;

import racing.domain.Grid;

public class ResultView {

    private static final String EXECUTE_RESULT = "실행 결과";

    public void play(Grid grid) {
        System.out.printf("\n");
        System.out.printf("%s \n",EXECUTE_RESULT);
        grid.getRaceRecord().stream().forEach(e -> print(e));
    }

    public void print(String input) {
        System.out.printf("%s",input);
    }

}
