package com.vwmattr.kotlinweatherapp.ui.presenter

import com.nhaarman.mockito_kotlin.verify
import com.vwmattr.kotlinweatherapp.ui.ForecastView
import io.reactivex.disposables.Disposable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations.initMocks

/**
 * Unit tests for [ForecastPresenter]
 */
class ForecastPresenterTest {

    @Mock
    lateinit var forecastView : ForecastView
    lateinit var presenter : ForecastPresenter

    @Before
    fun setUp() {
        initMocks(this)
        presenter = ForecastPresenter(forecastView)
    }

    @Test
    fun stopPresenting() {
        //1) Arrange
        val forecastDisposable : Disposable = mock(Disposable::class.java)
        presenter.forecastDisposable = forecastDisposable

        //2) Act
        presenter.stopPresenting()

        //3) Assert
        verify(forecastDisposable).dispose()
        assertThat(presenter.forecastDisposable).isNull()
    }

}
