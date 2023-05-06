package ru.netology.radio;

public class Radio {
    private int currentRadioStation; //значение 0

    private int totalRadioStations = 10;
    private int firstRadioStation = 0;
    private int lastRadioStation = 9;
    private int currentVolume; //значение 0
    private int minVolume = 0;
    private int maxVolume = 100;


    public Radio(int totalRadioStations) {
        this.totalRadioStations = totalRadioStations;
        lastRadioStation = totalRadioStations - 1;
    }

    public Radio() {
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public int getTotalRadioStations() {
        return totalRadioStations;
    }

    public int getFirstRadioStation() {
        return firstRadioStation;
    }

    public int getLastRadioStation() {
        return lastRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) { // выставляем номер станции
        if (newCurrentRadioStation < getFirstRadioStation()) {
            return;
        }
        if (newCurrentRadioStation > getLastRadioStation()) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) { // выставляем уровень громкости
        if (newCurrentVolume < minVolume) {
            return;
        }
        if (newCurrentVolume > maxVolume) {
            newCurrentVolume = maxVolume;
        }
        currentVolume = newCurrentVolume;
    }


    public void nextRadioStation() { // переключаем на 1 станцию вперед
        if (currentRadioStation == getLastRadioStation()) {
            setCurrentRadioStation(getFirstRadioStation());
        } else {
            currentRadioStation++;
        }
    }

    public void previousRadioStation() { // переключаем на 1 станцию назад
        if (currentRadioStation == getFirstRadioStation()) {
            setCurrentRadioStation(getLastRadioStation());
        } else {
            currentRadioStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume >= maxVolume) {
            setCurrentVolume(maxVolume);
        } else {
            currentVolume++;
        }
    }

    public void lowerVolume() {
        if (currentVolume <= minVolume) {
            setCurrentVolume(minVolume);
        } else {
            currentVolume--;
        }
    }
}
