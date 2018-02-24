package com.github.senin24.balls.app;

public class Ball {

    int positionX;
    int positionY;
    int number;
    long velocity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;

        Ball ball = (Ball) o;

        if (positionX != ball.positionX) return false;
        return positionY == ball.positionY;
    }

    @Override
    public int hashCode() {
        int result = positionX;
        result = 31 * result + positionY;
        return result;
    }

    public Ball(int positionX, int positionY, long velocity, int number) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocity = velocity;
        this.number = number;
    }

    //cons for check new position
    public Ball(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setVelocity(long velocity) {
        this.velocity = velocity;
    }

    public long getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
