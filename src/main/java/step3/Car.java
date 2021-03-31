package step3;

public class Car {
    
    private static final int MAXLENGTH_OF_NAME = 5; 
    
    private String name;
    private int move;
    
    public Car() {}
    
    public Car(String name) throws Exception {
        checkNameValidation(name);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) throws Exception {
        checkNameValidation(name);
        this.name = name;
    }

    public int getPosition() {
        return this.move;
    }
    
    public void move(boolean isMoveForward) {
        if( isMoveForward ) {
            this.move++;
        }
    }
    
    private void checkNameValidation(String name) throws Exception {
        if( name == null || name.isEmpty() ) {
            throw new IllegalStateException("차량명이 없습니다.");
        } 
        
        if( name.length() > MAXLENGTH_OF_NAME ) {
            throw new IllegalStateException(name + " 차량 명명규칙 부적합(최대길이 : " + MAXLENGTH_OF_NAME + ")");
        }
    }
    
}
