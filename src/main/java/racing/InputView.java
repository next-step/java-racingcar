package racing;

import racing.DTO.InputViewDTO;

import java.util.Scanner;

public class InputView {
    public static InputViewDTO inputValue() {
        Scanner scanner = new Scanner(System.in);
        InputViewDTO viewDTO = new InputViewDTO();
        System.out.println("자동차 대수는 몇 대 인가요?");
        viewDTO.setParticipants(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        viewDTO.setRound(scanner.nextInt());
        return viewDTO;
    }
}
