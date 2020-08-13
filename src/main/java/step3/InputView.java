package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private List<String> nameList = new ArrayList<>();
    private int rounds;

    private void setNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        String[] names = input.split(",");
        Collections.addAll(nameList, names);
    }

    private void setRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        this.rounds = scanner.nextInt();
    }

    public void init() {
        setNames();
        setRounds();
    }

    public List<String> getNameList() {
        return this.nameList;
    }

    public int getRounds() {
        return this.rounds;
    }

}
