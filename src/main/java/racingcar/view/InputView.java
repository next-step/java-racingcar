package racingcar.view;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class InputView {

    public int insertCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
