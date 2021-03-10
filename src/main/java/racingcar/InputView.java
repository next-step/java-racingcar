package racingcar;

import java.util.Scanner;

public class InputView {

    public int setInputPlayerCount() {
        int inputPlayerCount = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("참가 선수를 입력해주세요. (최소 2명, 최대 24명)");
                inputPlayerCount = scanner.nextInt();

                if (isPlayerLimit(inputPlayerCount)) {
                    break;
                }
            } catch (Exception e) {
                printInputError();
            }
        }

        return inputPlayerCount;
    }

    public int setInputLastLabCount() {
        int inputLabCount = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("목표 Lab을 입력해주세요. (최소 5Lab, 최대 55Lab)");
                inputLabCount = scanner.nextInt();

                if (isLabLimit(inputLabCount)) {
                    break;
                }
            } catch (Exception e) {
                printInputError();
            }
        }
        return inputLabCount;
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
