package com.vwmattr.kotlinweatherapp.domain.commands

/**
 * Interface defining a command.
 */
interface Command<T> {
    fun execute(): T
}