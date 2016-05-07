package com.fogodev.frogger;

import com.sun.media.sound.SimpleSoundbank;

import java.net.ServerSocket;
import java.util.HashSet;

public class Jogo
{

    private Frog frog;
    private Car[] street1;
    private Car[] street2;
    private Car[] street3;
    private Car[] street4;
    private int lifes;
    private boolean gameOver;

    public Jogo()
    {
        this.reset();

        this.street1 = new Car[2];
        this.street2 = new Car[1];
        this.street3 = new Car[3];
        this.street4 = new Car[3];

        for(int i = 0; i < street1.length; i++){
            street1[i] = new Car((i * 275), 100, 150, 100);
        }

        for(int i = 0; i < street2.length; i++){
            street2[i] = new Car((i * 175), 200, 350, 150);
        }

        for(int i = 0; i < street3.length; i++){
            street3[i] = new Car((i * 175), 300, 100, 60);
        }

        for(int i = 0; i < street4.length; i++){
            street4[i] = new Car((i * 175), 400, 135, 60);
        }
    }

    private void reset()
    {
        frog = new Frog(getLargura() / 2, getAltura() - getAltura() / 6 + Frog.radius + 5, Cor.VERDE);
        gameOver = false;
        lifes = 3;



    }

    public String getTitulo()
    {
        return "Frogger";
    }

    public static int getLargura()
    {
        return 800;
    }

    public static int getAltura()
    {
        return 600;
    }

    public void tique(HashSet<String> teclas, double dt)
    {

        if((frog.getFinalPositionY() != frog.getInitialPositionY() || frog.getFinalPositionX() != frog.getInitialPositionX()) && !gameOver)
            frog.move(dt);

        if(gameOver){
            frog.setInitialPositionX(-666);
            frog.setInitialPositionY(-666);
        }

        Car streets[][] = {this.street1, this.street2, this.street3, this.street4};
        for(Car street[]: streets) {
            for (Car car : street) {
                car.move(dt);
            }
        }

        this.checkCollideFrogCar();
    }

    private void checkCollideFrogCar()
    {
        Car streets[][] = {this.street1, this.street2, this.street3, this.street4};
        for(Car street[]: streets){
            for(Car car: street){
                if(this.frog.getHitBox().intersection(car.getHitbox())){
                    this.lifes -= 1;
                    if(this.lifes == 0){
                        this.gameOver = true;
                    } else {
                        this.frog = new Frog(getLargura() / 2, getAltura() - getAltura() / 6 + Frog.radius + 5, Cor.VERDE);
                    }
                }
            }
        }
    }

    public void desenhar(Tela tela)
    {
        tela.retangulo(0, 0, getLargura(), getAltura() / 6, Cor.BRANCO);
        tela.retangulo(0, getAltura() - getAltura() / 6, getLargura(), getAltura() / 6, Cor.BRANCO);
        tela.texto("" + this.lifes, getLargura() - 60, getAltura() - getAltura() / 6 + 60, 60, Cor.AZUL);



        Car streets[][] = {this.street1, this.street2, this.street3, this.street4};
        for(Car street[] : streets){
            for(Car car : street){
                car.draw(tela);
            }
        }

        if(gameOver) tela.texto("Game Over", getLargura() / 2 - 270, getAltura() / 2, 100, Cor.CINZA);
        else frog.draw(tela);
    }


    public void tecla(String tecla)
    {
        if (tecla.equals("left") || tecla.equals("a")) frog.goLeft();
        if (tecla.equals("right") || tecla.equals("d")) frog.goRight();
        if (tecla.equals("up") || tecla.equals("w")) frog.goUp();
        if (tecla.equals("down") || tecla.equals("s")) frog.goDown();

        if (tecla.equals("escape")) this.reset();
    }

    public static void main(String[] args)
    {
        new Motor(new Jogo());
    }
}
