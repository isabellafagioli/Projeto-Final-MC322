package BoardView;

import Actor.IActor;

import javax.swing.*;
import java.awt.*;
import java.lang.Object;
import java.nio.file.*;

public class DinoInfo {

    JPanel Panel;


    public DinoInfo(IActor[] dinos, int next){

        Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));

        String activated = new String();

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");



        JPanel d1 = new JPanel();
        d1.setLayout(new BoxLayout(d1, BoxLayout.Y_AXIS));

        JLabel i1 = new JLabel(new ImageIcon(filePath.toString() +"/dino1.png"));
        JLabel name = new JLabel(dinos[0].getName());
        JLabel score = new JLabel("Score: " + dinos[0].getScore());

        if(dinos[0].getStarPowerUpOn()){
            activated = "activated";
        }
        else{
            activated = "not activated";
        }
        JLabel powerUp1 = new JLabel("Star PowerUp: " + activated);

        if(dinos[0].getHasEgg()){
            activated = "Yes";
        }
        else{
            activated = "No";
        }
        JLabel egg1 = new JLabel("Egg captured: " + activated);

        d1.add(name, BorderLayout.NORTH);
        d1.add(score, BorderLayout.CENTER);
        d1.add(i1, BorderLayout.SOUTH);
        d1.add(powerUp1,BorderLayout.SOUTH);
        d1.add(egg1, BorderLayout.SOUTH);
        Panel.add(d1);


        JPanel d2 = new JPanel();
        d2.setLayout(new BoxLayout(d2, BoxLayout.Y_AXIS));
        JLabel i2 = new JLabel(new ImageIcon(filePath.toString() +"/dino2.png"));
        JLabel n2 = new JLabel(dinos[1].getName());
        JLabel s2 = new JLabel("Score: " + dinos[1].getScore());
        if(dinos[1].getStarPowerUpOn()){
            activated = "activated";
        }
        else{
            activated = "not activated";
        }
        JLabel powerUp2 = new JLabel("Star PowerUp: " + activated);

        if(dinos[1].getHasEgg()){
            activated = "Yes";
        }
        else{
            activated = "No";
        }
        JLabel egg2 = new JLabel("Egg captured: " + activated);

        d2.add(n2, BorderLayout.NORTH);
        d2.add(s2, BorderLayout.CENTER);
        d2.add(i2, BorderLayout.SOUTH);
        d2.add(powerUp2,BorderLayout.SOUTH);
        d2.add(egg2, BorderLayout.SOUTH);

        Panel.add(d2);

        JPanel d3 = new JPanel();
        d3.setLayout(new BoxLayout(d3, BoxLayout.Y_AXIS));
        JLabel i3 = new JLabel(new ImageIcon(filePath.toString() + "/dino3.png"));
        JLabel n3 = new JLabel(dinos[2].getName());
        JLabel s3 = new JLabel("Score: " + dinos[2].getScore());
        if(dinos[2].getStarPowerUpOn()){
            activated = "activated";
        }
        else{
            activated = "not activated";
        }
        JLabel powerUp3 = new JLabel("Star PowerUp: " + activated);
        if(dinos[2].getHasEgg()){
            activated = "Yes";
        }
        else{
            activated = "No";
        }
        JLabel egg3 = new JLabel("Egg captured: " + activated);


        d3.add(n3, BorderLayout.NORTH);
        d3.add(s3, BorderLayout.CENTER);
        d3.add(i3, BorderLayout.SOUTH);
        d3.add(powerUp3, BorderLayout.SOUTH);
        d3.add(egg3, BorderLayout.SOUTH);

        Panel.add(d3);


        JPanel d4 = new JPanel();
        d4.setLayout(new BoxLayout(d4, BoxLayout.Y_AXIS));
        JLabel i4 = new JLabel(new ImageIcon(filePath.toString() +"/dino4.png"));
        JLabel n4 = new JLabel(dinos[3].getName());
        JLabel s4 = new JLabel("Score: " + dinos[3].getScore());
        if(dinos[3].getStarPowerUpOn()){
            activated = "activated";
        }
        else{
            activated = "not activated";
        }
        JLabel powerUp4 = new JLabel("Star PowerUp: " + activated);
        if(dinos[3].getHasEgg()){
            activated = "Yes";
        }
        else{
            activated = "No";
        }
        JLabel egg4 = new JLabel("Egg captured: " + activated);

        d4.add(n4, BorderLayout.NORTH);
        d4.add(s4, BorderLayout.CENTER);
        d4.add(i4, BorderLayout.SOUTH);
        d4.add(powerUp4, BorderLayout.SOUTH);
        d4.add(egg4, BorderLayout.SOUTH);

        Panel.add(d4);

        JPanel nextPlayer = new JPanel();
        nextPlayer.setLayout(new BoxLayout(nextPlayer, BoxLayout.Y_AXIS));
        JLabel text = new JLabel("Next Player");
        JLabel icon = new JLabel();
        switch (next){
            case 0:
                icon = new JLabel(new ImageIcon(filePath.toString() +"/dino1mini.png"));
                break;
            case 1:
                icon = new JLabel(new ImageIcon(filePath.toString() +"/dino2mini.png"));
                break;
            case 2:
                icon = new JLabel(new ImageIcon(filePath.toString() +"/dino3mini.png"));;
                break;
            case 3:
                icon = new JLabel(new ImageIcon(filePath.toString() +"/dino4mini.png"));;
                break;
        }

        nextPlayer.add(text, BorderLayout.NORTH);
        nextPlayer.add(icon, BorderLayout.SOUTH);

        Panel.add(nextPlayer);

    }

    public JPanel getPanel(){
        return Panel;
    }

}
