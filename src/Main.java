
import controller.ManageWorker;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author This PC
 */
public class Main {
    public static void main(String[] args) {
        String title= "Worker Management";
        String[] s= new String[] {"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"};
        new ManageWorker(title, s).run();
    }
}
