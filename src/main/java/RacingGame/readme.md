#기능 요구사항 정리

###inputView
1. 경주에 참가할 자동차 댓수를 입력받는다.
    1. 공백이나 숫자외의 문자열은 assertThatIllegalArgumentException 
2. 자동차를 전진할 횟수를 입력받는다. 
    1. 공백이나 숫자외의 문자열은 assertThatIllegalArgumentException
 
###핵심로직   
1. 전진 조건값을 구한다. 
    1. 랜덤한 수를 구한다. 
        1. 0~9사이의 값을 구한다.
    2. 4이상이면 전진한다.
2. inputView와 ResultView를 관리한다.
 
    
### ResultView
1. 자동차 이동시마다 화면에 출력한다. 
