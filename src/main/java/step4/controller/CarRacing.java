package step4.controller;

import step4.model.CarRecord;
import step4.model.Car;
import step4.utility.ReturnValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {

    private Car[] cars;
    private int numOfTries;
    private CarRecord[] carRecord;
    private int numOfCars;

    public CarRacing(Car[] cars, int numOfTries) {
        this.cars = cars;
        this.numOfTries = numOfTries;
        numOfCars = cars.length;
        carRecord = new CarRecord[numOfCars];

        for (int i = 0; i < cars.length; i++) {
            carRecord[i] = new CarRecord(cars[i].getName());
        }
    }

    public CarRecord[] getCarRecord() {
        return carRecord;
    }

    public void gameStart() {
        for (int i = 0; i < numOfTries; i++) {
            run();
        }
    }

    void run() {
        for (int i = 0; i < numOfCars; i++) {
            cars[i].move(ReturnValue.returnValue());
            carRecord[i].resultRecording(cars[i].getPosition());
        }
    }

    public static void calculateWinner(CarRecord[] cars) {
        int[] record = new int[cars.length];
        List<String> winnerList;
        List<Integer> recordList;
        int lastIndex;
        int lastRecord;

        for (int i = 0; i < cars.length; i++) {
            recordList = cars[i].getRecordList();
            lastIndex = recordList.size();
            lastRecord = recordList.get(lastIndex - 1);

            record[i] = lastRecord;
        }
        winnerList = topOfRace(record, cars);

        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i) + " ");
        }
        System.out.println("가 최종 우승했습니다.");

    }

    private static List<String> topOfRace(int[] record, CarRecord[] cars) {
        List<String> result = new ArrayList<>();

        int maxValue = Arrays.stream(record).max().getAsInt();

        for (int i = 0; i < record.length; i++) {
            if (record[i] == maxValue) {
                result.add(cars[i].getCarName());
            }
        }
        return result;
    }
}


