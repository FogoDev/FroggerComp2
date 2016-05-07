package com.fogodev.frogger;

/**
 * Criado por ericson em 06/05/16.
 *
 * https://github.com/fogodev
 */
public class Hitbox
{
    public static int TOP = 1;
    public static int LEFT = 2;
    public static int BOTTOM = 3;
    public static int RIGHT = 4;

    private double topLeftCornerX;
    private double topLeftCornerY;
    private double bottomRightCornerX;
    private double bottomRightCornerY;

    public Hitbox(double topLeftCornerX, double topLeftCornerY, double bottomRightCornerX, double bottomRightCornerY)
    {
        this.topLeftCornerX = topLeftCornerX;
        this.topLeftCornerY = topLeftCornerY;
        this.bottomRightCornerX = bottomRightCornerX;
        this.bottomRightCornerY = bottomRightCornerY;
    }

    public void move(double topLeftCornerX, double topLeftCornerY, double bottomRightCornerX, double bottomRightCornerY)
    {
        this.topLeftCornerX = topLeftCornerX;
        this.topLeftCornerY = topLeftCornerY;
        this.bottomRightCornerX = bottomRightCornerX;
        this.bottomRightCornerY = bottomRightCornerY;
    }

    public boolean inside(double positionX, double positionY)
    {
        return positionX >= this.topLeftCornerX && positionX <= this.bottomRightCornerX &&
                positionY >= this.topLeftCornerY && positionY <= this.bottomRightCornerY;
    }

    public boolean intersection(Hitbox hitbox)
    {
        double weight = ((this.bottomRightCornerX - this.topLeftCornerX) + (hitbox.bottomRightCornerX - hitbox.topLeftCornerX)) / 2;
        double height = ((this.bottomRightCornerY - this.topLeftCornerY) + (hitbox.bottomRightCornerY - hitbox.topLeftCornerY)) / 2;
        double dPositionX = ((this.bottomRightCornerX + this.topLeftCornerX) - (hitbox.bottomRightCornerX + hitbox.topLeftCornerX)) / 2;
        double dPositionY = ((this.bottomRightCornerY + this.topLeftCornerY) - (hitbox.bottomRightCornerY + hitbox.topLeftCornerY)) / 2;

        if(Math.abs(dPositionX) <= weight && Math.abs(dPositionY) <= height){

//            double wy = weight * dPositionY;
//            double hx = height * dPositionX;
//
//            if(wy > hx){
//                if(wy > - hx){
//                    return true;
//                } else {
//                    return LEFT;
//                }
//            } else {
//                if(wy > - hx){
//                    return RIGHT;
//                } else {
//                    return TOP;
//                }
//            }
            return true;
        }

        return false;
    }
}
