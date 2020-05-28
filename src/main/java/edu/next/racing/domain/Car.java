/*
 * car object class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 자동차 추 객체
 *상
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class Car implements CarInterface{

    /** 자동차 현재 위치 */
    private int position = 1;
    private String name = "";
    protected static final int MAX_RANDOM_COUNT = 10;
    protected static final int MOVEABLE_NUMBER = 4;
    private List<Integer> record = new ArrayList<>();
    protected Random rand = new Random();

    public Car(String name) {
        this.name = name;
        this.record.add(position);
    }

    /**
     * @return position 위치 리턴
     */
    public int getPosition() {
        return position;
    }

    public int getRecord(int i) {
        return record.get(i);
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        position += (isMoveable()) ? 1 : 0;
    }

    public void record() {
        record.add(position);
    }

    @Override
    public boolean isMoveable() {
        return true;
    }
}
