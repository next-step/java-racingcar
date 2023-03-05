package racingcar;

public class Car {

    String name;
    int count;

    Car(String name) {
        this.name = name;
    }

    Car(String name, int ount) {
        this.name = name;
        this.count = count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    void addCount() {
        this.count++;
    }

    public String getCountPrint() {
        String returnStr = "";
        for(int i=0; i<this.count; i++) {
            returnStr += "-";
        }
        return returnStr;
    }

}
