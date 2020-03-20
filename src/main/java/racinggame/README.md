# racing game 요구사항 기능 정리

**RacingApplication**
1. 사용자에게 2 개의 정수를 입력 받는다. (scanner 이용)
    1. 입력값1 : 자동차의 수
    1. 입력값2 : 이동 수

**NumberVo**
1. 입력값이 정수 인지 체크
1. 0~9 사이의 random 값을 구하는 기능
1. 입력값이 4 이상인치 체크 
    
**InputView**    
1. 입력값1 크기의 List 생성
1. List의 크기가 1 이상인지 체크
1. 1에서 생성한 List에 랜덤 숫자 insert

**ResultView**
1. 전달 받은 정수가 4보다 크면 정수 만큼 - 표기
1. List\<integer>를 받고 크기 만큼 1번 기능 실행
1. 입력값2(이동수) 만큼 2번 기능 실행