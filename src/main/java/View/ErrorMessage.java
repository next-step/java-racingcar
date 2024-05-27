package View;

import Model.Car;
import java.util.ArrayList;

public class ErrorMessage {
    public ArrayList<Car> catchNameException(){
        Input input = new Input();
        while(true){
            try{
                return input.getName();
            }
            catch(IllegalArgumentException e){
                System.out.println("[ERROR] 잘못된 값을 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }

    public int catchCountException(){
        while(true){
            Input input = new Input();
            try{
                return input.getCount();
            }
            catch(IllegalArgumentException e){
                System.out.println("[ERROR] 잘못된 값을 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }
}
