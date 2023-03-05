package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRacing {

    public void car() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner inCars = new Scanner(System.in);
        String cars = inCars.nextLine();
        // 자동차 리스트 셋팅
        List<Car> carList = carSet(cars);

        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner inCnt = new Scanner(System.in);
        int cnt = inCnt.nextInt();

        // 시도횟수
        startRacing(carList, cnt);

        // 결과값(최대값 구하기)
        int maxScore = maxScore(carList);
        System.out.println("최대점수 : " + maxScore);

        // 결과값 셋팅
        String result = makeResult(carList, maxScore);
        // 결과 출력
        System.out.println("최종 우승자 : " + result);
    }

    /* 자동차 입력 list */
    private List<Car> carSet(String cars) {
        String[] actual = cars.split(",");
        List<Car> carList = new ArrayList<>();

        // 초기셋팅
        for (String s : actual) {
            // 자동차 이름 validate 체크
            validate(s);
            Car car = new Car(s, 0);
            carList.add(car);
        }
        return carList;
    }

    /* 시도 횟수 */
    private void startRacing(List<Car> carList, int cnt) {
        for (int i=0;i<cnt;i++) {
            System.out.println(i+1 + " 회차 start!!");
            for (Car car : carList) {
                // 점수획듯 - 전진 or 정지
                car.addSore(dice());
                System.out.println(car.name + " 의 점수 : " + car.score);
            }
        }
    }

    /* 결과값(최대값 구하기) */
    private int maxScore(List<Car> carList) {
        int score = 0;
        for (int j=0;j<carList.size();j++) {
            if (j == 0) {
                score = carList.get(j).score;
                continue;
            }
            // 스코어 비교
            score = comScore(score, carList.get(j).score);
        }
        return score;
    }

    /* 결과값 셋팅 */
    private String makeResult(List<Car> carList, int maxScore) {
        String result = "";
        for (int j=0;j<carList.size();j++) {
            if (maxScore == carList.get(j).score) {
                result = resultSet(result, carList.get(j).name, j);
            }
        }
        return result;
    }

    /* validate - 자동차 이름 5자 이내 */
    private void validate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    /* 결과값 셋팅 (concat) */
    private String resultSet(String result, String winner, int j) {
        if (j == 0) {
            return result.concat(winner);
        }
        return result.concat(", ").concat(winner);
    }

    /* 스코어 비교 */
    public int comScore(int a, int b) {
        if (a - b > 0) {
            return a;
        }
        return b;
    }

    /* 점수 획득 */
    public int dice() {
        Random random = new Random();
        int next = random.nextInt(10);
        if (next >= 4) {
            return 1;
        }
        return 0;
    }

}
