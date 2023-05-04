package ru.netology.radio;

public class Radio {
    private int currentRadioStation; //значение 0
    private int currentVolume; //значение 0

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) { // выставляем номер станции
        if (newCurrentRadioStation < 0) {
            newCurrentRadioStation = 9;
        }
        if (newCurrentRadioStation > 9) {
            newCurrentRadioStation = 0;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) { // выставляем уровень громкости
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            newCurrentVolume = 100;
        }
        currentVolume = newCurrentVolume;
    }


    public void nextRadioStation() { // переключаем на 1 станцию вперед
        if (currentRadioStation < 9) {
            currentRadioStation = currentRadioStation + 1;
        } else {
            currentRadioStation = 0;
        }
    }

    public void previousRadioStation() { // переключаем на 1 станцию назад
        if (currentRadioStation < 9) {
            currentRadioStation = currentRadioStation - 1;
        } else {
            currentRadioStation = 0;
        }
        if (currentRadioStation < 0) {
            currentRadioStation = 9;
        }
    }

    public void increaseVolume() { // увеличение звука на 1
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void lowerVolume() { // уменьшение звука на 1
        if (currentVolume < 100) {
            currentVolume = currentVolume - 1;
        }
        if (currentVolume < 0) {
            currentVolume = 0;
        }
    }
}


