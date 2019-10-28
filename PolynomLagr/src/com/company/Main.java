package com.company;

import Controller.LagrangeController;
import Model.Polynom;
import View.ConsoleView;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        ConsoleView consoleView = new ConsoleView();
        LagrangeController lagrangeController= new LagrangeController(consoleView);
        lagrangeController.start();

    }
}
