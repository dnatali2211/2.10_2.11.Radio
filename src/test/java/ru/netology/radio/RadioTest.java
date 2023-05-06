package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    Radio radio = new Radio(89);

    @Test
    public void testTotalRadioStations() {

        Assertions.assertEquals(89, radio.getTotalRadioStations());
    }

    @Test
    public void testLastRadioStation() {

        Assertions.assertEquals(88, radio.getLastRadioStation());
    }

    @Test
    public void shouldSetRadioStation() { // установка станции путем нажатия кнопки
        radio.setCurrentRadioStation(6);

        int expected = 6;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetRadioStationAboveLastStation() { // установка станции выше последней
        radio.setCurrentRadioStation(89);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchNextRadioStation() { // переключаем на 1 станцию вперед
        radio.setCurrentRadioStation(7);

        radio.nextRadioStation();

        int expected = 8;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchNextRadioStationIfAboveMax() { // переключаем на 1 станцию вперед, находясь на последней станции
        radio.setCurrentRadioStation(88);

        radio.nextRadioStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchPreviousRadioStation() { // переключаем на 1 станцию назад
        radio.setCurrentRadioStation(5);

        radio.previousRadioStation();

        int expected = 4;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchPreviousRadioStationIfBelowMin() { // переключаем на 1 станцию назад, находясь на первой станции
        radio.setCurrentRadioStation(0);

        radio.previousRadioStation();

        int expected = 88;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchPreviousRadioStationIfBelowZero() { // отрицательное значение
        radio.setCurrentRadioStation(-1);

        radio.previousRadioStation();

        int expected = 88;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolume() { // установка громкости
        radio.setCurrentVolume(57);

        int expected = 57;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeIfBelowZero() { // установка громкости ниже 0
        radio.setCurrentVolume(-1);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() { // увеличиваем громкость на 1
        radio.setCurrentVolume(89);

        radio.increaseVolume();

        int expected = 90;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeIfAboveMax() { // увеличиваем громкость на 1 при достижении максимальной громкости
        radio.setCurrentVolume(101);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLowerVolume() { // уменьшаем громкость на 1
        radio.setCurrentVolume(53);

        radio.lowerVolume();

        int expected = 52;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotLowerVolume() { // уменьшаем громкость на 1 при достижении минимальной громкости
        radio.setCurrentVolume(0);

        radio.lowerVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}