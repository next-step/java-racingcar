package step5.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RaceInput {

    private final List<String> nameOfCars = new ArrayList<>();

    private final int numberOfTries;

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String SEPARATOR = ",";

    public RaceInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표를 기준으로 구분)");
        this.nameOfCars.addAll(Arrays.asList(SCANNER.next().split(SEPARATOR)));
        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.numberOfTries = Integer.parseUnsignedInt(SCANNER.next());
        System.out.println();
    }

    public List<String> nameOfCars() {
        return this.nameOfCars;
    }

    public int numberOfTries() {
        return this.numberOfTries;
    }
}
