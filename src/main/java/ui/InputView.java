package ui;

import dto.InputDto;

import java.util.Scanner;

public class InputView {

    public static InputDto getInputDto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carSize = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int trySize = scanner.nextInt();
        return new InputDto(carSize, trySize);
    }

}
