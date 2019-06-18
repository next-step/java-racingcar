/*
 * ClassName : Car.java
<<<<<<< HEAD
<<<<<<< HEAD
 *
 * Version : 1.0
 *
 * Create Date : 2019.06.17
 *
 * Creator : 신익수
 *
=======
 * 
=======
 *
>>>>>>> fix(Car) : carPosition 변수의 자료형 변경 int->String
 * Version : 1.0
 *
 * Create Date : 2019.06.17
 *
 * Creator : 신익수
<<<<<<< HEAD
 * 
>>>>>>> feat(Car) : Car 클래스파일 생성
=======
 *
>>>>>>> fix(Car) : carPosition 변수의 자료형 변경 int->String
 */
package com.iksoo.step3;

public class Car {
<<<<<<< HEAD
    private int inning;
    private String carName;
    private String[] carPosition;

    Car(String name, int totalInning) {
        this.inning = 0;
        this.carName = name;
        this.carPosition = new String[totalInning];
    }

    public String getCarName() {
        return this.carName;
    }

    public int getTotalInning() {
        return this.carPosition.length;
    }

    public void addNextInning(int random, int criterion) {
        this.carPosition[this.inning] = random >= criterion ? "1" : "0";
        this.inning++;
        printInningResult();
    }

    public int getFinalPosition() {
        int finalPosition = 0;

        for (int i = 0; i < this.inning; i++) {
            finalPosition += this.carPosition[i].equals("1") ? 1 : 0;
        }

        return finalPosition;
    }

    public void printInningResult() {
        String result = "";

        for (int i = 0; i < this.inning; i++) {
            result += this.carPosition[i].equals("1") ? "-" : "";
        }

        System.out.println(this.carName + " : " + result);
=======
    private String carName;
    private String carPosition;
    private static final int GOSTOP_CRITERION = 4;

    Car(String Name) {
        this.carName = Name;
        this.carPosition = "";
    }

    public boolean judgeGoOrStop(int number) {
        return number >= GOSTOP_CRITERION ? true : false;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getCarPosition() {
        return this.carPosition;
>>>>>>> fix(Car) : carPosition 변수의 자료형 변경 int->String
    }
}
