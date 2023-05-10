package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int currentRadioStation;
    private int totalRadioStations = 10;
    private int firstRadioStation;
    private int lastRadioStation = 9;
    private int currentVolume;
    private int minVolume;
    private int maxVolume = 100;

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation >= this.getFirstRadioStation()) {
            if (newCurrentRadioStation <= this.getLastRadioStation()) {
                this.currentRadioStation = newCurrentRadioStation;
            }
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume >= this.minVolume) {
            if (newCurrentVolume > this.maxVolume) {
                newCurrentVolume = this.maxVolume;
            }
            this.currentVolume = newCurrentVolume;
        }
    }

    public void nextRadioStation() {
        if (this.currentRadioStation == this.getLastRadioStation()) {
            this.setCurrentRadioStation(this.getFirstRadioStation());
        } else {
            ++this.currentRadioStation;
        }
    }

    public void previousRadioStation() {
        if (this.currentRadioStation == this.getFirstRadioStation()) {
            this.setCurrentRadioStation(this.getLastRadioStation());
        } else {
            --this.currentRadioStation;
        }
    }

    public void increaseVolume() {
        if (this.currentVolume >= this.getMaxVolume()) {
            this.setCurrentVolume(this.getMaxVolume());
        } else {
            ++this.currentVolume;
        }
    }

    public void lowerVolume() {
        if (this.currentVolume <= this.getMinVolume()) {
            this.setCurrentVolume(this.getMinVolume());
        } else {
            --this.currentVolume;
        }
    }

    public Radio(int totalRadioStations) {
        this.totalRadioStations = totalRadioStations;
        this.lastRadioStation = getTotalRadioStations() - 1;
    }
}