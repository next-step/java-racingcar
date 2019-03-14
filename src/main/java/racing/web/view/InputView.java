package racing.web.view;

import spark.Request;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> inputNames(Request request) {
        return Arrays.asList(
                request.queryParams("names")
                    .split(" "));
    }

    public static int inputTime(Request request) {
        return Integer.parseInt(
                request.queryParams("turn"));
    }
}
