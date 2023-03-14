package racing;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarInputInfo {
    private Scanner scan = new Scanner(System.in);
    private static final String CAR_ENTRY_ENTER_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRACK_COUNT_ENTER_TEXT = "시도할 횟수는 몇 회인가요?";

    Cars getCarEntry() {
        System.out.println(CAR_ENTRY_ENTER_TEXT);
        String entry = scan.next();

        return new Cars(Stream.of(entry.split(",")).collect(Collectors.toList()));
    }

    int getTrackCount() {
        System.out.println(TRACK_COUNT_ENTER_TEXT);
        return scan.nextInt();
    }


}