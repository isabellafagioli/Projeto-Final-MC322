
import ControlP.*;

import java.util.ConcurrentModificationException;

public class AppDinoWorld {

    public static void main(String[] args) {

        TextFieldEvent textFieldEvent = new TextFieldEvent();
        while (textFieldEvent.names[0] == null){
            textFieldEvent.getDinoNames();
        }

        String[] names = textFieldEvent.names;


        for(int i = 0; i < 4; i++){
            System.out.println("na app dino world: " + names[i]);
        }

        IControl controller = new Control();
        controller.executeGame(names);
    }
}

