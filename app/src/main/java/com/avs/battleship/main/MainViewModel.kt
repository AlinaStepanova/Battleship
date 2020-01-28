package com.avs.battleship.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avs.battleship.R
import com.avs.battleship.battle_field.BattleField

class MainViewModel : ViewModel() {

    var status = MutableLiveData<Int>()

    init {
        status.value = R.string.welcome_text
    }

    var battleField = BattleField()

    override fun onCleared() {
        super.onCleared()
    }

    fun handleUIEventById(id: Int) {
        when (id) {
            R.id.viewGenerate -> {
                generateShips()
            }
            R.id.viewStart -> {
                startGame()
            }
            R.id.viewFire -> {
                makeFire()
            }
        }
    }

    fun handlePCAreaClick(x: Float, y: Float) {

    }

    private fun makeFire() {

    }

    private fun startGame() {

    }

    private fun generateShips() {

    }
}