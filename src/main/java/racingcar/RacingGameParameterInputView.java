package racingcar;

import racingcar.vo.RacingGameParameter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameParameterInputView {
    public RacingGameParameter readRacingGameParameter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesString = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        System.out.println();

        scanner.close();

        List<String> carNames = convertCarNamesStringToList(carNamesString);
        return new RacingGameParameter(carNames, tryCount);
    }

    private List<String> convertCarNamesStringToList(String carNamesString) {
        List<String> convertedCarNamesList = Arrays.stream(carNamesString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return convertedCarNamesList;
    }
}
