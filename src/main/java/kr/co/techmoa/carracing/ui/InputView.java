package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.ui.dto.InputDTO;

import java.util.Scanner;

public class InputView {

    public final InputDTO inputDTO = new InputDTO();
    public final Scanner SCANNER = new Scanner(System.in);

    public InputView() {
        inputDTO.setCarNum(getCarSu());
        inputDTO.setCarNames(getCarNames());
        inputDTO.setTryNumber(getRounds());
    }

    public int getCarSu() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        if(SCANNER.hasNextLine()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }

    public String getCarNames() {
        System.out.println("자동차 이름은 어떻게 되나요?");
        if(SCANNER.hasNextLine()) {
            return SCANNER.next();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }

    public int getRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        if(SCANNER.hasNextLine()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }

    public InputDTO getInputDTO() {
        return this.inputDTO;
    }
}
