package ru.netology.radio;

public class Radio {
    private int currentRadioStation; //значение 0
    private int currentVolume; //значение 0

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) { // выставляем номер станции
        if (newCurrentRadioStation < 0) {
            return;
        }
        if (newCurrentRadioStation > 9) {
            return;
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
        if (currentRadioStation == 9) {
            setCurrentRadioStation(0);
        } else {
            currentRadioStation++;
        }
    }

    public void previousRadioStation() { // переключаем на 1 станцию назад
        if (currentRadioStation == 0) {
            setCurrentRadioStation(9);
        } else {
            currentRadioStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume >= 100) {
            setCurrentVolume(100);
        } else {
            currentVolume++;
        }
    }

    public void lowerVolume() {
        if (currentVolume <= 0) {
            setCurrentVolume(0);
        } else {
            currentVolume--;
        }
    }
}
