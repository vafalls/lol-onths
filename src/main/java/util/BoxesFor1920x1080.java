package util;

import java.awt.*;
import java.util.ArrayList;

public class BoxesFor1920x1080 {

	public static int startXCoordinate = 269;
	public static int startYCoordinate = 421;
	public static int xDiff = 281;
	public static int yDiff = 552;
	public static Dimension nameField = new Dimension(260, 19);
	public static ArrayList<Rectangle> boxesToCheck = new ArrayList<Rectangle>();
	
	static {
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate,
				startYCoordinate), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 1 * xDiff,
				startYCoordinate), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 2 * xDiff,
				startYCoordinate), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 3 * xDiff,
				startYCoordinate), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 4 * xDiff,
				startYCoordinate), nameField));

		boxesToCheck.add(new Rectangle(new Point(startXCoordinate,
				startYCoordinate + yDiff), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 1 * xDiff,
				startYCoordinate + yDiff), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 2 * xDiff,
				startYCoordinate + yDiff), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 3 * xDiff,
				startYCoordinate + yDiff), nameField));
		boxesToCheck.add(new Rectangle(new Point(startXCoordinate + 4 * xDiff,
				startYCoordinate + yDiff), nameField));
	}
}
