package step3.present;

import step3.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputPresent {
    public static final String PARTICIPATES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    public static final String ITERATIONS = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputPresent() {
        this.scanner = new Scanner(System.in);
    }

    public List<Car> participates() {
        System.out.println(PARTICIPATES);
        return Arrays.stream(scanner.nextLine().split(",")).map(s -> new Car(s))
            .collect(Collectors.toList());
    }

    public int iterations() {
        System.out.println(ITERATIONS);
        return scanner.nextInt();
    }
}
