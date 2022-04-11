package me.devyonghee.racingcar;

import me.devyonghee.racingcar.controller.RacingCarRace;

import java.util.Scanner;

public class RacingcarApplication {

    public static void main(String[] args) {
        RacingCarRace.of(new Scanner(System.in), System.out).race();
    }
}
