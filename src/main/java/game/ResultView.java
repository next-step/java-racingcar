package game;

import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class ResultView {

    public static String MESSAGE_RESULT = "\n실행 결과";
    private Result result;

    public ResultView(Result result) {
        this.result = result;
    }

    public void render() {
        List<String> results = result.getExecutionResults();
        System.out.println(MESSAGE_RESULT);
        results.forEach(System.out::println);
    }
}
