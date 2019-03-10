package racingcar;

import java.util.List;

public class Output {
    static void print(List<String> paths) {
        System.out.println("실행결과");
        paths.forEach(System.out::println);
    }
}
