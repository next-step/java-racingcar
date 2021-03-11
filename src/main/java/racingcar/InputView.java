package racingcar;

import java.util.Scanner;

public class InputView {

    public int setInputPlayerCount() {
        int inputPlayerCount = 0;
        while (!isPlayerLimit(inputPlayerCount)) {
            inputPlayerCount = inputPlayerCount();
        }
        return inputPlayerCount;
    }

    public int inputPlayerCount() {
        int result = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("참가 선수를 입력해주세요. (최소 2명, 최대 24명)");
            result = scanner.nextInt();
        } catch (Exception e) {
            printInputError();
        }

        return result;
    }

    public int setInputLastLabCount() {
        int labCount = 0;
        while (!isLabLimit(labCount)) {
            labCount = inputLabCount();
        }
        return labCount;
    }

    public int inputLabCount() {
        int result = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("목표 Lab을 입력해주세요. (최소 5Lab, 최대 55Lab)");
            result = scanner.nextInt();

        } catch (Exception e) {
            printInputError();
        }
        return result;
    }

    public boolean isPlayerLimit(int playerCount) {
        return 2 <= playerCount && playerCount <= 24;
    }

    public boolean isLabLimit(int labCount) {
        return 5 <= labCount && labCount <= 55;
    }

    public void printInputError(){
        System.out.println("잘못 입력했습니다.");
    }
}
