package main;

import gui.*;
import java.io.*;

import javax.swing.SwingUtilities;

import net.sourceforge.tess4j.*;

public class Main {
	public static void main(String[] args) throws IOException, TesseractException {
		Executioner exec = new Executioner();
//		exec.run();
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonDemo.createAndShowGUI();
            }
        });
		
	}
}
