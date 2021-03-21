package study.exception;

public class NameInvalidException extends RuntimeException{
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public NameInvalidException(){
        super();
    }

    public NameInvalidException(String name){
        super(name);
        blankCheck(name);
        lengthCheck(name);
    }

    private void blankCheck(String name){
        if(name == null || name.trim().isEmpty()){
            System.out.println("차 이름은 빈 값이 될 수 없습니다."+this.getMessage());
        }
    }

    private void lengthCheck(String name){
        if(name.length() >= CAR_NAME_LENGTH_LIMIT){
            System.out.println("차 이름의 길이는 5이상이 될 수 없습니다. Length : "+this.getMessage().length());
        }
    }
}
