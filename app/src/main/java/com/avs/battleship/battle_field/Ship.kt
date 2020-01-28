package com.avs.battleship.battle_field

import com.avs.battleship.MAX_SHIP_SIZE
import java.util.*
import kotlin.collections.ArrayList

abstract class Ship() {

    enum class Orientation {
        VERTICAL, HORIZONTAL
    }

    protected var cells: ArrayList<Cell> = ArrayList(MAX_SHIP_SIZE)
    protected var orientation: Orientation
    protected lateinit var row: IntRange
    protected lateinit var column: IntRange

    init {
        orientation = when (Random().nextBoolean()) {
            true -> Orientation.VERTICAL
            false -> Orientation.HORIZONTAL
        }
    }

    protected fun initCells() {
        for (index in 0..getLength()) {
            cells[index] = Cell(CellState.SHIP)
        }
        cells.trimToSize()
    }

    protected fun setCellsCoordinates(i: Int, j: Int) {
        var iPos = i
        var jPos = j
        if (orientation == Orientation.VERTICAL) {
            row = IntRange(i, i + getLength() - 1)
            column = IntRange(j, j)
            for (index in 0..getLength()) {
                cells[index].setCoordinates(iPos, jPos)
                iPos++
            }
        } else {
            row = IntRange(i, i)
            column = IntRange(j, j + getLength() - 1)
            for (index in 0..getLength()) {
                cells[index].setCoordinates(iPos, jPos)
                jPos++
            }
        }
    }

    protected fun isDead(): Boolean {
        var isDead = true
        for (cell in cells) {
            if (cell.getCellState() == CellState.SHIP) {
                isDead = false
                break
            }
        }
        return isDead
    }

    abstract fun getLength(): Int

}