package com.kkambi.racing.view;

import com.kkambi.racing.domain.Racer;

import java.util.List;

public class ResultView {

    public void printLocation(List<Racer> racerList) {
        for (Racer racer : racerList) {
            System.out.println(racer.getLocation());
        }
        System.out.println();
    }
}
