package step03;

import java.util.Arrays;

public class ResultView {

    public static void print(String[] process) {

        Arrays.stream(process)
                .forEach((element) -> {
                    System.out.println(element);
                });
        System.out.println();
    }
}
