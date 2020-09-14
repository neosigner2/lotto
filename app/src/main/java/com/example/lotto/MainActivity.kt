package com.example.lotto
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    //1~46까지의 수 중에서 하나를 랜덤으로 뽑는 함수 지정
    fun getRandomLottoNumber(): Int{
        return Random().nextInt(45)+1
    }

    //for를 6번 돌려서 6개의 임의의 수가 들어있는 mutablelist를 만들고 이를 lottoNumbers라고 지정
    fun getRandomLottoNumbers(): MutableCollection<Int> {
        val lottoNumbers = mutableListOf<Int>()

        for (i in 1..6){
            var number = 0
            do{
                number = getRandomLottoNumber()
            } while (lottoNumbers.contains(number))

            lottoNumbers.add(number)
        }
        return lottoNumbers
    }
    //셔플 함수
    fun getShuffleLottoNumbers(): MutableList<Int> {
        //mutablelist는 배열같음
        val list = mutableListOf<Int>()
        //1부터 45까지의 숫자를 mutablelist에 추가
        for (number in 1..45) {
            list.add(number)
        }
        //리스트를 suffl
        list.shuffle()
        //
        return list.subList(0, 6)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "역전로또"

        randomCard.setOnClickListener {
            val intent =Intent(this,ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))
            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }
        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }

    }
}
