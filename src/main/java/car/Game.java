package car;

import java.util.*;

public class Game {

    public String carNameinput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(\\,)를 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String countInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] splitBlank(String str) {
        return str.split(",");
    }

    public void excute() {

        String carInput = carNameinput();

        String[] carInputs = splitBlank(carInput);

        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < carInputs.length; i++) {
            // 이름 잘라주는거
            cars.add(getCar(carInputs[i]));
        }

        if (cars.size() < 2)
            return;

        String count = countInput();

        System.out.println("실행 결과");
        carRacing(toInt(count), cars);
    }

    public Integer toInt(String number) {
        return Integer.valueOf(number);
    }

    public Car getCar(String carName) {
        int length = carName.length();
        if(length > 5)
            length = 5;
        Car c = new Car();
        carName = carName.substring(0, length);
        c.setName(carName);
        return c;
    }

    public void carRacing(int count, List<Car> cars) {

        int nowCount = 0;

        while (nowCount < count) {
            carDrive(cars);

            printCars(cars);

            nowCount++;
        }

        printWinner(cars);
    }

    public int getMoveValue() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) return 1;
        return 0;
    }

    public void carDrive(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int nowKm = cars.get(i).getKm();
            cars.get(i).setKm(nowKm + getMoveValue());
        }
    }

    public String printLines(int km) {
        String lines = "";
        for (int i = 0; i < km; i++) {
            lines = lines + "-";
        }
        return lines;
    }

    public void printCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + " : " + printLines(cars.get(i).getKm()));
        }
        System.out.println("");
    }

    public String getWinner(Car car, int max) {
        if (car.getKm() == max)
            return car.getName() + ',';
        return "";
    }

    public void printWinner(List<Car> cars) {
        StringBuilder winners = new StringBuilder();

        int[] kms = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            kms[i] = cars.get(i).getKm();
        }

        Arrays.sort(kms);

        int max = kms[kms.length - 1];

        for (int i = 0; i < cars.size(); i++) {
            winners.append(getWinner(cars.get(i), max));
        }
        System.out.println("최종 우승자: " + winners.substring(0, winners.length() - 1));
    }
}
