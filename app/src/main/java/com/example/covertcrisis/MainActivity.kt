package com.example.covertcrisis

import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.covertcrisis.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

   fun operationAction(view: View) {
        if(view is Button && canAddOperation){ //if is a button and can add an operation do so
            binding.workingsTextView.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }
    fun numberAction(view: View) {
        if(view is Button){
            if(view.text == "."){
                if(canAddDecimal) //if num doesnt have a decmial yet then add it
                    binding.workingsTextView.append(view.text)
                canAddDecimal = false //now set to false
            }
            else {
                binding.workingsTextView.append(view.text) //append inputed button number
                canAddOperation = true
            }
        }
    }
    fun allClearAction(view: View) {
        binding.workingsTextView.text = ""
        binding.resultsTextView.text = ""
        canAddOperation = false
    }
    fun backSpaceAction(view: View) { //backspace function
        val length = binding.workingsTextView.text.length
        if(length > 0) {
            binding.workingsTextView.text =
                binding.workingsTextView.text.substring(0, length - 1) //erase last digit
            if(length == 1)
                canAddOperation = false
        }

    }
    fun equalsAction(view: View) {
        binding.resultsTextView.text = calculateResult()
    }

    private fun calculateResult(): String {
        val digitsOperators = digitsOperators()
        if(digitsOperators.isEmpty())
            return ""
        val timesDivison = timesDivisionCalculate(digitsOperators)
        if(digitsOperators.isEmpty())
            return ""

        val result = addSubtractCalculate(timesDivison)
        return result.toString()
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
        var result = passedList[0] as Float

        for(i in passedList.indices){
            if(passedList[i] is Char && i != passedList.lastIndex){
                val operator = passedList[i]
                val nextDigit = passedList[i+1] as Float
                if(operator == '+'){
                    result += nextDigit
                }
                if(operator == '-'){
                    result -= nextDigit
                }
            }
        }

        return result
    }

    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var list = passedList
        while(list.contains('x') || list.contains('/')){
            list = calcTimesDiv(list)
        }
        return list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()

        var restartIndex = passedList.size
        for(i in passedList.indices){
            if(passedList[i] is Char && i != passedList.lastIndex && i < restartIndex){
                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when(operator){
                    'x'->{
                        newList.add(prevDigit*nextDigit)
                        restartIndex = i + 1
                    }
                    '/'->{
                        newList.add(prevDigit/nextDigit)
                        restartIndex = i + 1
                    }
                    else -> {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }
            if(i > restartIndex)
                newList.add(passedList[i])
        }
        return newList
    }

    private fun digitsOperators(): MutableList<Any> { //breaks workings text view into array of floats and characters
        val list = mutableListOf<Any>()
        var currentDigit = ""

        for(character in binding.workingsTextView.text){
            if(character.isDigit() || character == '.'){ //checks if digit or decimal
                currentDigit += character //appends that digit to current number
            }
            else{
                list.add(currentDigit.toFloat()) //add number to the list
                currentDigit = ""
                list.add(character) //adds character to list
            }
        }

        if(currentDigit != "") //to catch last number
            list.add(currentDigit.toFloat())

        return list
    }

}