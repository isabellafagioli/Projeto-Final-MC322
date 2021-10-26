package BoardView;

import Actor.IActor;
import Board.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GraphicInterface implements IGraphicInterface {

    public IBoard b;
    public IActor[] dinos;
    public JFrame f;
    Container content;
    MenuBar menuBar;
    BoardView bview;
    DinoInfo dinfo;
    JPanel panel1, panel2;

    public GraphicInterface(){
        this.b = null;
        this.f = new JFrame("DinoWorld");
        //Size the frame
        f.setLayout(new BorderLayout());
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.content = f.getContentPane( );
        content.setSize(1300, 1300);
        this.menuBar = new MenuBar();
        this.bview = null;
    }

    public void printGame(){
        //Create components and put them in the frame -> contentPane

        //menubar
        menuBar.createToolBar();
        JToolBar toolBar = menuBar.getToolBar();
        toolBar.setSize(100, 100);
        content.add(toolBar, BorderLayout.EAST);

        content.add(Box.createRigidArea(new Dimension(5,0)));

        //dinos
        dinfo = new DinoInfo(dinos, 0);
        panel1 = dinfo.getPanel();
        content.add(panel1, BorderLayout.WEST);

        //board
        bview = new BoardView(b, dinos);
        panel2 = bview.getPanel();
        content.add(panel2, BorderLayout.CENTER);

        //Show it
        f.setVisible(true);

        //Close JFrame
        f.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }

    public void updateBoardView(int next){
        content.remove(panel2);
        bview = new BoardView(b, dinos);
        panel2 = bview.getPanel();
        content.add(panel2,  BorderLayout.CENTER);

        content.remove(panel1);
        dinfo = new DinoInfo(dinos, next);
        panel1 = dinfo.getPanel();
        content.add(panel1,  BorderLayout.WEST);


        content.revalidate();
        content.repaint();


    }

    public void connect(IBoard b){
        this.b = b;
    }

    public void connect(IActor [] dinos) {this.dinos = dinos;}

    public JFrame getF(){
        return f;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public BoardView getBoardView(){
        return bview;
    }

}
