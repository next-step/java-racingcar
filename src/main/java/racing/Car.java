package racing;

public class Car {

    public final String name;

    public final int moveOption;

    private int position;

    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position){
        vaildName(name);

        this.position = position;
        this.name = name;
        this.moveOption = 4;
    }

    private void vaildName(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름이 5자를 초과했습니다.");
        }
    }

    public int move(int moveValue){
        if(moveOption <= moveValue){
            position++;
        }

        return position;
    }

    public String getPositionFormat(){
        return name + " : " + translatePosition(this.position);
    }

    public String translatePosition(int position){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < position; i++){
            sb.append("-");
        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}