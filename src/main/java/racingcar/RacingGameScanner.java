package racingcar;

import type.MessageFactory;

import java.util.Scanner;

import static java.util.Arrays.stream;

class RacingGameScanner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String STAGE_COUNT = "시도할 횟수는 몇 회인가요?";

    static String[] enterCarCount() {
        System.out.println(CARS_NAME);
        String inputStr = scanner.nextLine();

        if(!inputStr.contains(",") || inputStr.isBlank()) {
            throw new IllegalArgumentException(MessageFactory.getBadInputMessage());
        }

        String[] names = inputStr.split(",");
        long count = stream(names).distinct().count();

        if(names.length != count) {
            throw new IllegalArgumentException(MessageFactory.getDuplicatedInputMessage());
        }

        return names;
    }

    static int enterStageCount() {
        System.out.println(STAGE_COUNT);
        int stageCount = scanner.nextInt();

        if(stageCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다");
        }

        return stageCount;
    }
}
