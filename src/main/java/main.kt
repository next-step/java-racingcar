import kotlin.random.Random

data class Car(val name: String="", var pos: Int=0)

fun main(){
    //자동차 이름 입력
    val cars: Array<Car> = inputCarName()

    //횟수 입력
    val trialCnt = inputTrialCnt()

    race(cars,trialCnt)

    printWinnerCar(cars)
}

fun inputCarName(): Array<Car>{ //자동차 명 입력
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
    val carNames = readLine()?.split(",") ?: throw IllegalArgumentException("[ERROR]: 자동차 이름을 입력해 주세요")
    return carNames.map{ Car(it,0)}.toTypedArray()
}

fun inputTrialCnt(): Int{ //시도 횟수 입력
    print("시도할 횟수는 몇회인가요?\n")
    return readLine()?.toInt() ?: throw IllegalArgumentException("[ERROR]: 횟수를 입력해주세요")
}

fun calculateCarMovement(car: Car){ //전진 판단 계산
    //랜덤 값 생성 후 4이상이면 전진
    if(4 <= Random.nextInt(10))
        car.pos++
}

fun race(cars: Array<Car>, trialCnt: Int){ //경주
    println("실행 결과")
    repeat(trialCnt){
        cars.forEach { car->
            calculateCarMovement(car)

            println("${car.name}, ${"-".repeat(car.pos)}")
        }
        println()
    }
    println()
}

fun printWinnerCar(cars: Array<Car>){
    val maxPos = cars.maxByOrNull { it.pos }?.pos
    val winners = cars.filter {it.pos == maxPos}.joinToString(", ") { it.name }

    println("최종 우승자 : ${winners}")
}