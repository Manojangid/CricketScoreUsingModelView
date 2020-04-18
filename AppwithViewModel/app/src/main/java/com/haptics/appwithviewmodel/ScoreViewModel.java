package com.haptics.appwithviewmodel;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    private int runs = 0;
    private int firstDigit = 1;
    private int secondDigit = 0;

    public int getFirstDigit() {
        return firstDigit;
    }

    public void setFirstDigit(int firstDigit) {
        this.firstDigit = firstDigit;
    }

    public int getSecondDigit() {
        return secondDigit;
    }

    public void setSecondDigit(int secondDigit) {
        this.secondDigit = secondDigit;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}
