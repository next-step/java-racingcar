package racinggame.domain;

import java.util.Scanner;

public class GameInit {


    public String[] inputPlayerName(){
        String playerNames="";
        String[] playerNameList;
        while (true){
            Scanner scanner = new Scanner(System.in);
            playerNames = scanner.nextLine();
            playerNameList = playerNames.split(",");
            boolean isValidate = validationStringLength(playerNameList);
            if(isValidate==true){
                break;
            }
        }

        return playerNameList;
    }

    public int inputTryNumber(){
        Scanner scanner = new Scanner(System.in);
        int tryNumber = scanner.nextInt();
        return tryNumber;
    }

    private boolean validationStringLength(String[] playerNameList ){
        boolean isValidate=true;
        for (String playerName: playerNameList) {
            if(playerName.length()>5){
                System.out.println("자동차의 이름은 5자를 초과할 수 없습니다.");
                isValidate=false;
            }
        }
        return isValidate;
    }

}
