package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {


    @Test
    public void shouldSetRadioStation() { // установка станции путем нажатия кнопки
        Radio radio = new Radio();

        radio.setCurrentRadioStation(6);

        int expected = 6;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetRadioStationBelowFirstStation() {
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetRadioStationAboveLastStation() {
        Radio radio = new Radio();

        radio.setCurrentRadioStation(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchNextRadioStation() { // переключаем на 1 станцию вперед
        Radio radio = new Radio();

        radio.setCurrentRadioStation(7);

        radio.nextRadioStation();

        int expected = 8;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchNextRadioStationIfAboveMax() { // переключаем на 1 станцию вперед, находясь на последней станции
        Radio radio = new Radio();

        radio.setCurrentRadioStation(9);

        radio.nextRadioStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchPreviousRadioStation() { // переключаем на 1 станцию назад
        Radio radio = new Radio();

        radio.setCurrentRadioStation(5);

        radio.previousRadioStation();

        int expected = 4;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchPreviousRadioStationIfBelowMin() { // переключаем на 1 станцию назад, находясь на первой станции
        Radio radio = new Radio();

        radio.setCurrentRadioStation(0);

        radio.previousRadioStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchPreviousRadioStationIfAboveLastStation() { // отрицательное значение
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);

        radio.previousRadioStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolume() { // установка громкости
        Radio radio = new Radio();

        radio.setCurrentVolume(57);

        int expected = 57;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeIfBelowZero() { // установка громкости ниже 0
        Radio radio = new Radio();

        radio.setCurrentVolume(-1);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() { // увеличиваем громкость на 1
        Radio radio = new Radio();

        radio.setCurrentVolume(89);

        radio.increaseVolume();

        int expected = 90;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeIfAboveMax() { // увеличиваем громкость на 1 при достижении максимальной громкости
        Radio radio = new Radio();

        radio.setCurrentVolume(101);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLowerVolume() { // уменьшаем громкость на 1
        Radio radio = new Radio();

        radio.setCurrentVolume(53);

        radio.lowerVolume();

        int expected = 52;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotLowerVolume() { // уменьшаем громкость на 1 при достижении минимальной громкости
        Radio radio = new Radio();

        radio.setCurrentVolume(0);

        radio.lowerVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotLowerVolumeIfBelowZero() { // отрицательное значение
        Radio radio = new Radio();

        radio.setCurrentVolume(-1);

        radio.lowerVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotLowerVolumeIfAboveMaxLoud() { // значение больше максимального
        Radio radio = new Radio();

        radio.setCurrentVolume(102);

        radio.lowerVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}