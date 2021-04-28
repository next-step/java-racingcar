package racingcar.vo;

public class Car {
    private String name;
    private String locationInfo;

    public void setName(String name){
        this.name = name;
    }
    public void setLocationInfo(String locationInfo){
        this.locationInfo = locationInfo;
    }
    public String getName(){
        return name;
    }
    public String getLocationInfo(){
        return locationInfo;
    }
}
