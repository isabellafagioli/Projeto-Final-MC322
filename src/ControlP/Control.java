package ControlP;

import Actor.*;
import Board.*;
import BoardView.*;
import Builder.*;
import Cell.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ControlP.TextFieldEvent;

import javax.swing.*;


public class Control implements IControl {

    public IBoard b;
    private IActor[] dinos = new Actor[4];
    private IVolcano[] volcanoes = new Volcano[4];
    private int roundNumber, winnersNum;
    public IGraphicInterface graphicInterface;
    public int dinoPos;
    public static int command, turno, turno_anterior;


    public Control(){
        this.roundNumber = 1;
        this.winnersNum = 0;
        this.graphicInterface = new GraphicInterface();
        command = 0;
        turno = -1;
        turno_anterior = -1;
        this.dinoPos = 0;
    }

    public void executeGame(String[] names) {

        //create board and actors
        IBuilder builder = new Builder();
        builder.newBoard(this);


        graphicInterface.connect(b);

        //get dino names


        for (int z = 0; z < 4; z++) {
            dinos[z].setName(names[z]);
        }


        //print game
        graphicInterface.connect(dinos);
        graphicInterface.connect(b);
        graphicInterface.printGame();

        //buttonUpperLeft - 7, buttonUp - 8, buttonUpperRight - 9, buttonLeft - 4, buttonEgg - 5, buttonRight - 6, buttonLowerLeft - 1, buttonDown - 2, buttonLowerRight - 3;
        graphicInterface.getMenuBar().buttonUpperLeft.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 7 apertado");
            command = 7;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });

        graphicInterface.getMenuBar().buttonUp.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 8 apertado");
            command = 8;
            turno++;
            System.out.println("c" + command + "t" + turno);


        });


        graphicInterface.getMenuBar().buttonUpperRight.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 9 apertado");
            command = 9;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });


        graphicInterface.getMenuBar().buttonLeft.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 4 apertado");
            command = 4;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });

        graphicInterface.getMenuBar().buttonEgg.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 5 apertado");
            command = 5;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });

        graphicInterface.getMenuBar().buttonRight.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 6 apertado");
            command = 6;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });

        graphicInterface.getMenuBar().buttonLowerLeft.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 1 apertado");
            command = 1;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });

        graphicInterface.getMenuBar().buttonDown.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 2 apertado");
            command = 2;
            turno++;
            System.out.println("c" + command + "t" + turno);

        });

        graphicInterface.getMenuBar().buttonLowerRight.addActionListener(actionEvent -> {
            System.out.println("reconheceu botao 3 apertado");
            command = 3;
            turno++;
            System.out.println("c: " + command + " t: " + turno + " t+1: " + turno_anterior + " cond: " + (turno == turno_anterior + 1));

        });

        while (atLeastOneAlive()) {
            System.out.println();
            if (turno == turno_anterior + 1) {


                dinoPos = turno % 4;

                System.out.println("entrou no if do turno: dino " + dinoPos);


                if (dinos[dinoPos].getIsAlive()) {
                    System.out.println("dino " + dinoPos + "vivo ");
                    if (command != 0) {
                        System.out.println("num comando " + command);
                        System.out.println("pos dino " + dinoPos);
                        System.out.println("turno " + turno);
                        //System.out.println("posicoes iniciais do dino: i:" + dinos[dinoPos].getI() + "j:" + dinos[dinoPos].getJ());
                        makeMove(command, dinoPos);
                        //System.out.println("posicoes iniciais do dino: i:" + dinos[dinoPos].getI() + "j:" + dinos[dinoPos].getJ());
                        command = 0;
                    }
                }
                else {
                    turno++;

                }
                turno_anterior++;

                if (dinoPos == 3) {
                    b.insertLavas(volcanoes);

                    graphicInterface.updateBoardView(next(dinoPos));
                    roundNumber++;
                    if(winnersNum != 0){
                        //one or more have reached the fort
                        //decide who wins
                        int winner = whoWins(winnersNum);
                        System.out.println(dinos[winner].getName() + "has won the game");
                        break;
                    }

                }
            }
        }

        if (!atLeastOneAlive()){
            System.out.println("No dino has won this round");
        }

    }


    public  int next(int dinoPos){
        int next;

        if(dinoPos != 3){
            next = dinoPos + 1;
        }
        else{
            next = 0;
        }
        while(!dinos[next].getIsAlive()){
            if(next != 3){
                next = next + 1;
            }
            else{
                next = 0;
            }
        }
        return next;
    }
    public int whoWins(int winnersNum){
        //check if more than one dino has reached its fort
        if(winnersNum > 1){
            //decide who wins based on the score
            int first = -1;
            for(int i = 0; i < 4; i++){
                if(dinos[i].getHasWon()){
                    if(first != -1){
                        if(dinos[i].getScore() > dinos[first].getScore()){
                            first = i;
                        }
                    }
                    else{
                        first = i;
                    }
                }
            }
            return first;
        }
        else if (winnersNum == 1) {
            for(int i = 0; i < 4; i++){
                if(dinos[i].getHasWon()){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean atLeastOneAlive(){
        if(dinos[0].getIsAlive() || dinos[1].getIsAlive() || dinos[2].getIsAlive() || dinos[3].getIsAlive()){
            return true;
        }
        return false;
    }

    public void makeMove(int command, int i){

        int destinyX = 0, destinyY = 0;

        //up
        if (command == 8) {
            destinyX = dinos[i].getI() - 1;
            destinyY = dinos[i].getJ();
        }

        //right
        if (command == 6) {
            destinyX = dinos[i].getI();
            destinyY = dinos[i].getJ() + 1;
        }

        //left
        if (command == 4) {
            destinyX = dinos[i].getI();
            destinyY = dinos[i].getJ() - 1;
        }

        //down
        if (command == 2) {
            destinyX = dinos[i].getI() + 1;
            destinyY = dinos[i].getJ();
        }

        //upper-right corner
        if (command == 9) {
            destinyX = dinos[i].getI() - 1;
            destinyY = dinos[i].getJ() + 1;
        }

        //upper-left corner
        if (command == 7) {
            destinyX = dinos[i].getI() - 1;
            destinyY = dinos[i].getJ() - 1;
        }

        //lower-right corner
        if (command == 3) {
            destinyX = dinos[i].getI() + 1;
            destinyY = dinos[i].getJ() + 1;
        }

        //lower-left corner
        if (command == 1) {
            destinyX = dinos[i].getI() + 1;
            destinyY = dinos[i].getJ() - 1;
        }

        int pointstoadd = 0;

        //hatch egg
        boolean capturedEgg = false;
        if (command == 5) {
            capturedEgg = b.captureEgg(dinos[i]);
            if (capturedEgg) {
                destinyX = dinos[i].getEggX();
                destinyY = dinos[i].getEggY();
                if(roundNumber < 10){
                    pointstoadd = 100 - ((roundNumber - 1) * 10);
                }
            }
        }

        boolean surpriseUsed = false;
        //solicitate move to board (the board validates it and updates dino info)
        if (command != 5) {

            surpriseUsed = b.verifySurprise(destinyX, destinyY);
            if(surpriseUsed){
                ICell[][] cells = b.getCellsSpace();
                pointstoadd = cells[destinyX][destinyY].getSurprise().pointsToAdd();
            }

            b.move(dinos[i], destinyX, destinyY);
            //verify if there's a surprise


        }

        //update board (remove visited surprises and captured eggs)

        dinos[i].updateScore(pointstoadd);
        b.updateBoard(capturedEgg, surpriseUsed, destinyX, destinyY);
        if (dinos[i].getHasWon()) {
            winnersNum++;
        }

        graphicInterface.updateBoardView(next(dinoPos));
        //print game no console



    }
    @Override
    public void connect(IBoard b) {
        this.b = b;
    }

    public void connect(int idx, IActor actor) {
        dinos[idx] = actor;
    }

    public void connect(int idx, IVolcano v){
        volcanoes[idx] = v;
    }
    public IActor[] getDinos(){
            return dinos;
    }

    public IGraphicInterface getGraphicInterface( ){
        return graphicInterface;
    }


}


