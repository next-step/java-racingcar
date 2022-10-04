package racing.view;

import racing.core.RacingDto;

import java.util.Scanner;

public class InputView {

    private RacingDto racingDto;
    private final Scanner scanner = new Scanner(System.in);

    private static final String carQuestion = "자동차 대수는 몇 대 인가요?";
    private static final String tryQuestion = "시도할 회수는 몇 회 인가요?";

    public InputView() {}

    public void start(){
        System.out.println(carQuestion);
        int carCount = scanner.nextInt();
        System.out.println(tryQuestion);
        int tryCount = scanner.nextInt();
        this.racingDto = RacingDto.builder()
                .carCount(carCount)
                .tryCount(tryCount)
                .build();
    }

    public RacingDto getRacingDto() {
        return racingDto;
    }
}
