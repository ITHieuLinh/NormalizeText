package main;

import controller.NormalizeText;
import model.TextNomalizeModel;

public class Main {

    public static void main(String[] args) {
        TextNomalizeModel model = new TextNomalizeModel();

        new NormalizeText(model).run();
    }

}
