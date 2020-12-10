package com.jaenyeong.mission2.racingcar.view;

import java.util.List;

public interface Input {
    int CAN_NOT_READ = -1;

    int inputHowManyTryTimes();

    List<String> inputNamesOfTheCarsToBeRaced();
}
