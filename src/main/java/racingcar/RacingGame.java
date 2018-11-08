package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static final int RANGEOFNUM = 10;
    static final int LIMIT = 4;

    private String carsName;
    public String[] names;
    private String[] winners;
    private ArrayList<Car> cars;
    public int[] whoWin;

    public int numOfCars;
    private int racingTracks;

    private void racingGame() {
        inputValue();
        racing();
        initArrays();

        int winnerNum = 0;

        winnerNum = findMaximum(winnerNum);
        checkWinner(winnerNum);
        repeatInsert();

        displayWinner();
    }

    private void displayWinner() {
        for(int i=0; i<cars.size(); i++) {
            printWinner(i);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private void printWinner(int i) {
        if(winners[i] != "") {
            System.out.print(winners[i]);
            System.out.print(printComma(i));
        }
    }

    public String printComma(int i) {
        if(i != numOfCars-1 && winners[i+1] != "") {
            return ", ";
        }
        return "";
    }

    private void repeatInsert() {
        for(int i=0; i<cars.size(); i++) {
            winners[i] = checkCar(i);
        }
    }

    private String checkCar(int i) {
        if(whoWin[i] > 0) {
            return names[i];
        }
        return "";
    }

    private void checkWinner(int winnerNum) {
        int i=0;
        for(Car car : cars) {
            checkIndex(winnerNum, i, car);
            i++;
        }
    }

    private void checkIndex(int winnerNum, int i, Car car) {
        if(car.getCurPosition() == winnerNum) {
            whoWin[i] = 1;
        }
    }

    private int findMaximum(int winnerNum) {
        for(Car car : cars) {
            winnerNum = compareNum(winnerNum, car.getCurPosition());
        }
        return winnerNum;
    }

    public int compareNum(int winnerNum, int i) {
        if(winnerNum < i) {
            winnerNum = i;
        }
        return winnerNum;
    }

    private void initArrays() {
        winners = new String[numOfCars];
        whoWin = new int[numOfCars];
    }

    private void inputValue() {
        Scanner sc = new Scanner(System.in);
        cars = new ArrayList<Car>();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carsName = sc.nextLine();
        names = carsName.split(",");
        numOfCars = names.length;
        System.out.println("시도할 횟수는 몇 회 인가요?");
        racingTracks = sc.nextInt();

        for(int i=0; i<numOfCars; i++) {
            cars.add(new Car(names[i]));
        }
    }

    private void racing() {
        for(int i=0; i<racingTracks; i++) {
            move();
            displayResult();
            System.out.println();
        }
    }

    private void displayResult() {
        for(Car car : cars) {
            String str = "";
            System.out.print(car.getName() + " : ");
            str = checkElement(car.getCurPosition(), str);
            System.out.println(str);
        }
    }

    private String checkElement(int i, String str) {
        if(i > 0) {
            str = drawLine(i);
        }
        return str;
    }

    public static String drawLine(int state) {
        String str = "";
        for(int i=0; i<state; i++) {
            str += "-";
        }
        return str;
    }

    public void move() {
        Random rand = new Random();
        for(Car car : cars) {
            int currentPos = rand.nextInt(RANGEOFNUM);
            int resultData = checkLimit(currentPos);
            car.setCurPosition(resultData);
        }
    }

    public int checkLimit(int currentPos) {
        if(currentPos >= LIMIT) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        RacingGame rg = new RacingGame();
        rg.racingGame();
    }
}
