package step3;

import java.util.*;
import java.util.stream.IntStream;

public class CarGame {
    private List<Car> cars;

    public CarGame() {
    }

    public CarGame(int carCnt) {
        cars = new ArrayList<>();
        for (int i=0; i<carCnt; i++) {
            cars.add(new Car());
        }
    }

    /**
     * 자동차 총대수 반환
     */
    public int getCarCnt() {
        return cars.size();
    }

    /**
     * 자동차 인스턴스 반
     * @param i
     * @return환
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /**
     * 랜덤 숫자를 기준으로 움직일수 있는지 판단해서 자동차를 움직인다.
     * @param carIdx
     * @param randomNum
     */
    public void canMove(int carIdx, int randomNum) {
        //4미만일때는 시도횟수만줄임
        if (randomNum < 4) {
            return;
        }

        //4이상일때는 전진하고 시도횟수 줄임
        getCar(carIdx).go();
    }

    /**
     * 자동차 거리를 화면에 출력한다.
     * @param carIdx
     */
    public void printDistance(int carIdx) {
        int curMove = getCar(carIdx).getMove();

        StringBuilder sb = new StringBuilder();
        while (curMove-- > 0) {
            sb.append("-");
        }

        System.out.println(sb.toString());
    }

    /**
     * 입력값이 숫자인지 아닌지 판단한다.
     * @param input
     * @return
     */
    public static boolean isDigit(String input) {
        if (input == null || input.trim().length() > 0) {
            return input.matches("[0-9]*");
        }

        return false;
    }

    /**
     * 자동차대수와 시도횟수를 입력받는다.
     * @param category
     * @return
     */
    public int ask(Message category) {
        int cnt = 0; //자동차대수 or 시도횟수

        while (cnt <= 0) {
            //입력받기
            Scanner sc = new Scanner(System.in);
            System.out.println(category.getInputMessage());
            String userInput = sc.nextLine();

            //숫자가 아닐경우 예외처리
            if (!isDigit(userInput)) {
                System.out.println("숫자로 입력해주세요.");
                continue;
            }

            cnt = Integer.parseInt(userInput);
            //0개 이상일 경우
            if (cnt > 0) {
                System.out.println("입력되었습니다.");
                return cnt;
            }

            //0개 이하 예외처리
            System.out.println(category.getErrorMessage());
        }

        return cnt;
    }

    /**
     * 전반적인 게임을 진행하는 메소드
     * @param tryCnt
     */
    public void playGame(int tryCnt) {
        IntStream
                .range(0, tryCnt)
                .forEach(i -> {
                    System.out.println((i+1) + "회차 결과");
                    IntStream
                            .range(0, getCarCnt())
                            .forEach(j -> {
                                int randomNum = generateRandomNumbers();
                                System.out.print((j+1) +"번차 랜덤숫자 = " + randomNum + "  ");
                                canMove(j, randomNum);
                                printDistance(j);
                            });
                    System.out.println();
                });
    }

    /**
     * 0~9 범위 랜덤숫자 발생
     * @return
     */
    public int generateRandomNumbers() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
