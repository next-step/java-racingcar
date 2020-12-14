package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.CarNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 자동차 경주 입력 클래스
 */
public class InputView {

    private static final String NAME_SPLIT_REGEX = ",";

    /**
     * 입력질문 출력
     * @param questions 입력질문
     */
    public void printQuestions(String questions) {
        System.out.println(questions);
    }

    /**
     * 자동차 수 입력받기
     * @param scanner 입력 스캐너
     * @return 자동차 수
     */
    public int inputCarCount(Scanner scanner) {
        return scanner.nextInt();
    }

    /**
     * 이동횟수 입력받기
     * @param scanner 입력 스캐너
     * @return 이동횟수
     */
    public int inputMoveCount(Scanner scanner) {
        return scanner.nextInt();
    }

    /**
     * 자동차 이름 입력받기
     * @param scanner 입력 스캐너
     * @return 자동차 이름 목록
     */
    public CarNames inputCarNames(Scanner scanner) {
        List<CarName> carNames = new ArrayList<>();
        String[] names = scanner.next().split(NAME_SPLIT_REGEX);
        for (String name : names) {
            carNames.add(new CarName(name));
        }
        return new CarNames(carNames);
    }

}
