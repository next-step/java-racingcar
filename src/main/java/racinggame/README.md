# racing game 요구사항 기능 정리

**RacingApplication**
1. 사용자에게 2 개의 정수를 입력 받는다. (scanner 이용)
    1. 입력값1 : 자동차의 수
    1. 입력값2 : 이동 수

**Car**
1. 자동차 번호 필드
1. 움직이는 거리 필드
1. 자동차 번호 get,set
1. 움직이는 거리 get,set

**NumberVo**
1. 0~9 사이의 random 값을 구하는 기능
1. 값이 정수 인지 체크
1. 값이 1 이상인치 체크
1. 값이 4 이상인치 체크
1. 게임 진행시 자동차 이동
    
**InputView**
1. Car의 List 필드
1. Car의 수 필드
1. 진행할 게임 수 필드   
1. NumberVo 이용하여 입력값이 정수 인지 체크
1. NumberVo 이용하여 입력 값이 1 이상인지 체크

**ResultView**
1. "-" 상수
1. 게임 수 만큼 자동차 이동
1. Car의 이동 거리 만큼 - 표기
