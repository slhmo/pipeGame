package application.project;

import javafx.scene.input.MouseButton;

public class MovingPipesStates {
    public static int setState(Integer state, MouseButton mouseButton) {
        switch (state) {
            case 1:
                state = 2;
                break;

            case 2:
                state = 1;
                break;

            case 3:
                state = state3(mouseButton);
                break;

            case 4:
                state = state4(mouseButton);
                break;

            case 5:
                state = state5(mouseButton);
                break;

            case 6:
                state = state6(mouseButton);
                break;


            default: break;
        }
        return state;
    }

    private static int state3(MouseButton mouseButton){
        if (mouseButton == MouseButton.PRIMARY) {return 4;}
        else {return 6;} //mouse button secondary
    }

    private static int state4(MouseButton mouseButton){
        if (mouseButton == MouseButton.PRIMARY) {return 5;}
        else {return 3;} //mouse button secondary
    }

    private static int state5(MouseButton mouseButton){
        if (mouseButton == MouseButton.PRIMARY) {return 6;}
        else {return 4;} //mouse button secondary
    }

    private static int state6(MouseButton mouseButton){
        if (mouseButton == MouseButton.PRIMARY) {return 3;}
        else {return 5;} //mouse button secondary
    }
}
