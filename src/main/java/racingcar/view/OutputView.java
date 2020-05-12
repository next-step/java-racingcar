package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void print(List<ResultView> resultViews) {
        System.out.println("실행 결과");
        System.out.println(createResult(resultViews));
    }

    private String createResult(List<ResultView> resultViews) {
        return resultViews.stream().map(ResultView::print)
            .collect(Collectors.joining("\n\n"));
    }
}
