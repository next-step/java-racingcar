package racingcar;


import java.util.*;

public class RacingGame {

    public static int numberOfCars = 0;
    public static int numberOfGames = 0;

    public static void racing(int carNumber, int gameNumber) {

        numberOfCars = carNumber;
        numberOfGames = gameNumber;

        ArrayList<Integer> gameResultList = new ArrayList<>(numberOfCars);
        
        System.out.println("##############################");
        for (int i = 0; i < numberOfGames; i++) {
            for (int j = 0; j < numberOfCars; j++) {
                if (i == 0) {
                    gameResultList.add(0);
                }
                if (calculateDistance(randomNumberExtraction())) {
                    gameResultList.set(j, gameResultList.get(j) + 1);
                }
                System.out.println(showDistance(gameResultList.get(j)));
            }
            System.out.println("##############################");
        }
    }

    // 랜덤넘버 추출
    public static int randomNumberExtraction() {
        Random random = new Random();
        return random.nextInt(10);
    }

    // 전진/스톰 리턴
    public static boolean calculateDistance(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    // (-).repeat(반복횟수)랑 동일 기능
    public static String showDistance(int distance) {
        return new String(new char[distance]).replace("\0", "-");
    }

}


