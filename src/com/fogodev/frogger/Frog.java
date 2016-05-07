package com.fogodev.frogger;

/**
 * Criado por ericson em 06/05/16.
 *
 * https://github.com/fogodev
 */
public class Frog
{

    private double initialPositionX;
    private double initialPositionY;
    private double finalPositionX;
    private double finalPositionY;
    private double velocityX = 87.5;
    private double velocityY = 100;
    private Cor color;
    public static int radius = 45;

    public Frog(double positionX, double positionY, Cor color)
    {
        this.initialPositionX = positionX;
        this.finalPositionX = positionX;
        this.initialPositionY = positionY;
        this.finalPositionY = positionY;
        this.color = color;
    }

    public void draw(Tela canvas)
    {
        canvas.circulo(this.initialPositionX, this.initialPositionY, radius, this.color);
    }

    public void goUp()
    {
        this.finalPositionY -= this.velocityY;
        if(this.finalPositionY <= - radius){
            this.finalPositionY += this.velocityY;
        }
    }

    public void goDown()
    {
        this.finalPositionY += this.velocityY;
        if (this.finalPositionY >= Jogo.getAltura() - radius) {
            this.finalPositionY -= this.velocityY;
        }
    }

    public void goLeft()
    {
        this.finalPositionX -= this.velocityX;
    }

    public void goRight()
    {
        this.finalPositionX += this.velocityX;
    }

    public void move(double dTime)
    {
        if(this.initialPositionX < this.finalPositionX){
            this.initialPositionX += 300 * dTime;
            if(this.finalPositionX > Jogo.getLargura() + radius){
                this.initialPositionX -= Jogo.getLargura();
                this.finalPositionX -= Jogo.getLargura();
            }
        }
        if(this.initialPositionX > this.finalPositionX){
            this.initialPositionX -= 300 * dTime;
            if(this.finalPositionX <  - radius){
                this.initialPositionX += Jogo.getLargura();
                this.finalPositionX += Jogo.getLargura();
            }
        }

        if(this.initialPositionY < this.finalPositionY) this.initialPositionY += 300 * dTime;
        if(this.initialPositionY > this.finalPositionY) this.initialPositionY -= 300 * dTime;
    }

    public Hitbox getHitBox()
    {
        return new Hitbox(this.initialPositionX - radius, this.initialPositionY - radius, this.initialPositionX + radius, this.initialPositionY + radius);
    }

    public double getInitialPositionX()
    {
        return initialPositionX;
    }

    public double getInitialPositionY()
    {
        return initialPositionY;
    }

    public double getFinalPositionX()
    {
        return finalPositionX;
    }

    public double getFinalPositionY()
    {
        return finalPositionY;
    }

    public void setInitialPositionX(double initialPositionX)
    {
        this.initialPositionX = initialPositionX;
    }

    public void setInitialPositionY(double initialPositionY)
    {
        this.initialPositionY = initialPositionY;
    }
}
