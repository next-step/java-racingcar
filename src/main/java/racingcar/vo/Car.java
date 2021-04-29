package racingcar.vo;

public class Car {
    private String name;
    private int locationInfo;

    public void setName(String name){
        this.name = name;
    }
    public void setLocationInfo(int locationInfo){
        this.locationInfo = locationInfo;
    }
    public String getName(){
        return name;
    }
    public int getLocationInfo(){
        return locationInfo;
    }
}
