package com.nurgulmantarci.eventbusstickykullanimi.EventModels;

public class PositionEvent {
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public PositionEvent(int position) {
        this.position = position;
    }
}
