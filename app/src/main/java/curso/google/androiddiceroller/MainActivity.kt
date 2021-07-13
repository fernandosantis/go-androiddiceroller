package curso.google.androiddiceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    var sorta = Dice(6).roll()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.bt_roll)
        rollButton.setOnClickListener { rollDice() }
        val resulte: TextView = findViewById(R.id.tv_result)
        resulte.text = "Lucky Num: $sorta"
    }

    /*
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val diceImage: ImageView = findViewById(R.id.iv_dice)
        diceImage.setImageResource(R.drawable.dice_2)

        val dice = Dice(6).roll()
        diceImage.setImageResource(
            when (dice) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        )

        var msg = ""
        if (dice == sorta) {
            msg = "Congrats! You Win"
        } else {
            msg = "Oh, no... Try Again"
        }
        // Update the screen with the dice roll
        Toast.makeText(this, "Dice Rolled! $msg", Toast.LENGTH_SHORT).show()
        sorta = Dice(6).roll()
        val resulte: TextView = findViewById(R.id.tv_result)
        resulte.text = "Lucky Num: $sorta"
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
