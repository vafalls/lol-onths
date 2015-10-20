package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.*;
import net.sourceforge.lept4j.*;
import net.sourceforge.lept4j.util.*;
import util.*;

public class Main {
	public static void main(String[] args) throws IOException, TesseractException {
		Executioner exec = new Executioner();
		exec.run();
	}
}
