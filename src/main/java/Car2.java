public class Car2 {
    private String name;
    private int distance;

    Car2(String name){
        this.name = name;
        this.distance = 0;
    }

    public String getName(){return this.name; }

    public int getDistance(){return this.distance;}

    public void setName(String name){
      this.name =name;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }

}
