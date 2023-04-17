package carrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String COMMA = ",";
    private static final String HOW_MANY_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MANY_LABS = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private int totalLabs;
    private final List<String> players;

    InputView() {
        this.totalLabs = 0;
        this.players = new ArrayList<>();
    }

    public void ask() {
        System.out.println(HOW_MANY_CARS);
        final String players = SCANNER.nextLine();
        this.players.addAll(Arrays.asList(players.split(COMMA)));

        System.out.println(HOW_MANY_LABS);
        totalLabs = SCANNER.nextInt();
    }

    public int getTotalLabs() {
        return totalLabs;
    }

    public List<String> getPlayers() {
        return players;
    }
}
