package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 자동차 경주 입력 클래스
 */
public class InputView {

    private int carCount;   // 경주용 자동차 수
    private int moveCount;  // 이동 횟수, 시도 횟수
    private List<CarName> carNames = new ArrayList<>();  // 경주 자동차 이름 목록
    private static final String NAME_SPLIT_REGEX = ",";

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

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
     */
    public void inputCarCount(Scanner scanner) {
        this.carCount = scanner.nextInt();
    }

    /**
     * 이동횟수 입력받기
     * @param scanner 입력 스캐너
     */
    public void inputMoveCount(Scanner scanner) {
        this.moveCount = scanner.nextInt();
    }

    /**
     * 자동차 이름 입력받기
     * @param scanner 입력 스캐너
     */
    public void inputCarNames(Scanner scanner) {
        String[] names = scanner.next().split(NAME_SPLIT_REGEX);
        for (String name : names) {
            this.carNames.add(new CarName(name));
        }
        this.carCount = names.length;
    }

}
