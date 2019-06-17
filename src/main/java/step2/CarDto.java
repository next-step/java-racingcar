package step2;

public class CarDto {

    private int position;
    private int executeNumber;

    public CarDto(){
        this.position = 0;
    }

    public int getPosition(){
        return this.position;
    }

    public void setUpdatePosition(int update) {
        if(executeNumber == 0){
            update = 1;
            executeNumber++;
        }
        this.position += update;
    }

}
