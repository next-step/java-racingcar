package racing.view;

import racing.domain.Grid;

public class ResultView {

    private static final String EXECUTE_RESULT = "실행 결과";

    public void racingResults(Grid grid) {
        System.out.print("\n");
        System.out.printf("%s \n",EXECUTE_RESULT);
        grid.getRaceRecord().forEach(this::print);
    }

    public void print(String input) {
        System.out.printf("%s",input);
    }

}
