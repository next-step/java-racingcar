package step3;

import java.util.List;

public class OutputView {
    public static void printResult(List<String> results) {
        System.out.println("실행 결과");
        results.forEach(System.out::println);
    }
}
