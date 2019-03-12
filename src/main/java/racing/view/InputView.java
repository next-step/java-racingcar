package racing.view;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputNames() {
        String names = input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                () -> sc.nextLine());


        return Stream.of(names.split(","))
                .collect(Collectors.toList());
    }

    public static int inputTime() {
        return input("시도할 회수는 몇 회 인가요?",
                () -> sc.nextInt());
    }

    private static <T> T input(String msg, Supplier<T> supplier) {
        System.out.println(msg);
        return supplier.get();
    }
}
