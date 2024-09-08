import kotlin.random.Random

data class Car(val name: String="", var pos: Int=0)

fun main(){
    //자동차 이름 입력
    val cars: Array<Car> = inputCarName()

    //횟수 입력
    val trialCnt = inputTrialCnt()
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