package me.namuhuchutong.step4;

public class UserRequest {

    private final String names;

    private final int times;

    public UserRequest(String names, int times) {
        this.names = names;
        this.times = times;
    }

    public String getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }
}
