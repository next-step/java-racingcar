package com.racing.game.vo;

import java.util.Objects;

public class Progress implements Comparable<Progress>{
    private final int value;

    private Progress(int value){
        if(value < 0){
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        this.value = value;
    }

    public static Progress from(int value){
        return new Progress(value);
    }

    public boolean isGreaterThan(int value){
        return value < this.value;
    }

    public boolean isSame(int value){
        return value == this.value;
    }

    public Progress goForward(){
        return new Progress(value + 1);
    }

    public String status(){
        return "-".repeat(value);
    }

    public int value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Progress progress = (Progress) o;
        return value == progress.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Progress other) {
        return value - other.value();
    }
}
