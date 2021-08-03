/*
* 클래스 이름  : Racing
* 버전 정보 : 0.0v
* 날짜 2021.07.27
* 저작권 주의 : 본 과제는 next-step 자료입니다.
* */

package racing;

import java.util.*;

public class Racing {

    private static ShowRacing showRacing = new ShowRacing();

    public static void main(String args[]) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Car> carList = setCar();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer tryNum = setNumber();
        playGame(carList, tryNum);

    }

    public static List<Car> setCar() {

        Scanner input = new Scanner(System.in);
        String names = input.nextLine();
        String[] nameArray = names.split(",");
        List<Car> result = new ArrayList<>();
        for(int i = 0; i < nameArray.length; i++) {
            Car car = new Car();
            car.setCarName(nameArray[i]);
            car.setCount(0);
            result.add(car);
        }

        return result;

    }

    public static Integer setNumber() {

        Scanner input = new Scanner(System.in);
        return input.nextInt();

    }

    public static void playGame(List<Car> carList, Integer tryNum) {

        while(!isGameOver(carList, tryNum)) {
            carList = setCarMove(carList);
        }
    }

    public static Boolean isGameOver(List<Car> carList, Integer tryNum) {

        List<Car> winnerList = new ArrayList<>();

        for(Car car : carList) {
            if (tryNum.equals(car.getCount())) {
                winnerList.add(car);
            }
        }

        if(winnerList.size() != 0) {
            showRacing.showWinner(winnerList);
            return true;
        }

        return false;
    }

    public static List<Car> setCarMove(List<Car> carList) {

        for(Car car : carList) {
            if(isMove(makeRanNum())) {
                int cntSize = car.getCount() + 1;
                car.setCount(cntSize);
                showRacing.showGame(cntSize, car.getCarName());
            }
        }

        return carList;
    }

    public static Integer makeRanNum() {

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(10);

    }

    public static Boolean isMove(Integer number) {

        if(number >= 4) {
            return true;
        }

        return false;
    }


}
