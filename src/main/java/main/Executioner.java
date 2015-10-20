package main;

import util.*;

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

import org.bytedeco.*;
import org.bytedeco.javacpp.Pointer;

public class Executioner {

	int writeFileCounter = 1;

	public void run() throws IOException, TesseractException {
		System.out.println("Start!");

		int summoner = 0;

		File sample_text = new File("./src/main/resources/maxresdefault.jpg");

		BufferedImage bi = new BufferedImage(1920, 1080, 1);

		for (int i = 0; i < 10; i++) {

			bi = ImageIO.read(sample_text);
			bi = bi.getSubimage(BoxesFor1920x1080.boxesToCheck.get(i).x,
					BoxesFor1920x1080.boxesToCheck.get(i).y,
					BoxesFor1920x1080.boxesToCheck.get(i).width,
					BoxesFor1920x1080.boxesToCheck.get(i).height);
			writeOutFile(bi);//1

			bi = ImageHelper.invertImageColor(bi);
			writeOutFile(bi);//2

			Pix pix = LeptUtils.convertImageToPix(bi);
			pix = Leptonica1.pixContrastTRC(pix, pix, (float)1);
			bi = LeptUtils.convertPixToImage(pix);
			writeOutFile(bi);//3
			
			pix = LeptUtils.convertImageToPix(bi);
			pix = Leptonica1.pixUnsharpMasking(pix, 5, (float)3);
			bi = LeptUtils.convertPixToImage(pix);
			writeOutFile(bi);//4
			
			bi = ImageHelper.convertImageToBinary(bi);
			writeOutFile(bi);//5
			
			pix = LeptUtils.convertImageToPix(bi);
			pix = Leptonica1.pixExpandBinaryPower2(pix, 2);
			bi = LeptUtils.convertPixToImage(pix);
			writeOutFile(bi);//6

			
//			bi = ImageHelper.convertImageToGrayscale(bi);
//			writeOutFile(bi);

			processImage(bi);
		}
		System.out.println("Stop!");
	}

	private void processImage(BufferedImage bi) throws TesseractException {
		Tesseract1 instance = new Tesseract1();
		instance.setTessVariable("tessedit_char_whitelist", "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZº");
		instance.setDatapath("./tessdata");
		for (int x = 0; x < 1; x++) {
			System.out.println(instance.doOCR(bi));
		}
	}

	private void writeOutFile(BufferedImage bi) throws IOException {

		File outputfile = new File("step" + writeFileCounter + ".png");
		ImageIO.write(bi, "png", outputfile);
		writeFileCounter++;
	}

	private BufferedImage getScreenshot() {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit
					.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("./target/screenshot.png"));
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (AWTException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
