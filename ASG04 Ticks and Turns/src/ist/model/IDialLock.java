package edu.psu.ist.model;

public interface IDialLock {
    void reset();
    void left(int t);
    void right(int t);
    int currentTick();
    boolean pull();
}