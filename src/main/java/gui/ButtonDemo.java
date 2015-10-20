package gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static gui.GuiContants.*;

public class ButtonDemo implements ActionListener {

	// Definition of global values and items that are part of the GUI.
	int redScoreAmount = 0;
	int blueScoreAmount = 0;

	JPanel startPanel, namePanel, resultPanel, exitPanel;
	JLabel redLabel, pictureLabel, redScore, blueScore;
	JButton redButton, blueButton, resetButton, startButton, sendResultsButton, exitButton;
	JTextField firstNameField, secondNameField, thirdNameField,
			fourthNameField, fifthNameField;

	ArrayList<TextField> inputBoxes = new ArrayList<TextField>();

	public JPanel createContentPane() {

		// We create a bottom JPanel to place everything on.
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		totalGUI = createFirstPanel(totalGUI);
		totalGUI = createSecondPanel(totalGUI);
		totalGUI = createThirdPanel(totalGUI);
		totalGUI = createFourthPanel(totalGUI);

		totalGUI.setOpaque(true);
		return totalGUI;
	}

	

	private JPanel createFirstPanel(JPanel totalGUI) {
		// Creation of a Panel to contain the title labels
		startPanel = new JPanel();
		startPanel.setLayout(null);
		startPanel.setLocation(DEFAULT_SPACE, DEFAULT_SPACE);
		startPanel.setSize(PANEL_WIDTH, PANEL1_HEIGHT);
		startPanel.setBackground(Color.RED);
		totalGUI.add(startPanel);

		startButton = new JButton("Start");
		startButton.setLocation(DEFAULT_SPACE, DEFAULT_SPACE);
		startButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		startButton.addActionListener(this);
		startPanel.add(startButton);

		pictureLabel = new JLabel("countdown");
		pictureLabel.setLocation(BUTTON_WIDTH + 2 * DEFAULT_SPACE,
				DEFAULT_SPACE);
		pictureLabel.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		pictureLabel.setHorizontalAlignment(0);
		pictureLabel.setForeground(Color.BLACK);
		startPanel.add(pictureLabel);
		return totalGUI;
	}

	private JPanel createSecondPanel(JPanel totalGUI) {
		// Creation of a Panel to contain the score labels.
		namePanel = new JPanel();
		namePanel.setLayout(null);
		namePanel.setLocation(DEFAULT_SPACE, PANEL1_HEIGHT + 2 * DEFAULT_SPACE);
		namePanel.setSize(PANEL_WIDTH, PANEL1_HEIGHT * 5 - 4 * DEFAULT_SPACE);
		namePanel.setBackground(Color.YELLOW);
		totalGUI.add(namePanel);

		firstNameField = new JTextField("Hello");
		firstNameField.setLocation(DEFAULT_SPACE, DEFAULT_SPACE);
		firstNameField.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		namePanel.add(firstNameField);

		secondNameField = new JTextField("Hello");
		secondNameField.setLocation(DEFAULT_SPACE, 2 * DEFAULT_SPACE
				+ BUTTON_HEIGHT);
		secondNameField.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		namePanel.add(secondNameField);

		thirdNameField = new JTextField("Hello");
		thirdNameField.setLocation(DEFAULT_SPACE, 3 * DEFAULT_SPACE + 2
				* BUTTON_HEIGHT);
		thirdNameField.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		namePanel.add(thirdNameField);

		fourthNameField = new JTextField("Hello");
		fourthNameField.setLocation(DEFAULT_SPACE, 4 * DEFAULT_SPACE + 3
				* BUTTON_HEIGHT);
		fourthNameField.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		namePanel.add(fourthNameField);

		fifthNameField = new JTextField("Hello");
		fifthNameField.setLocation(DEFAULT_SPACE, 5 * DEFAULT_SPACE + 4
				* BUTTON_HEIGHT);
		fifthNameField.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		namePanel.add(fifthNameField);

		return totalGUI;
	}

	private JPanel createThirdPanel(JPanel totalGUI) {
		resultPanel = new JPanel();
		resultPanel.setLayout(null);
		resultPanel.setLocation(DEFAULT_SPACE, 3 * DEFAULT_SPACE
				+ PANEL1_HEIGHT + PANEL2_HEIGHT);
		resultPanel.setSize(PANEL_WIDTH, PANEL3_HEIGHT);
		resultPanel.setBackground(Color.GREEN);
		totalGUI.add(resultPanel);

		sendResultsButton = new JButton("sendResults");
		sendResultsButton.setLocation(DEFAULT_SPACE, DEFAULT_SPACE);
		sendResultsButton.setSize(BUTTON_WIDTH*2, BUTTON_HEIGHT);
		sendResultsButton.addActionListener(this);
		resultPanel.add(sendResultsButton);
		return totalGUI;
	}
	
	private JPanel createFourthPanel(JPanel totalGUI) {
		exitPanel = new JPanel();
		exitPanel.setLayout(null);
		exitPanel.setLocation(DEFAULT_SPACE, 4 * DEFAULT_SPACE
				+ PANEL1_HEIGHT + 2*PANEL2_HEIGHT);
		exitPanel.setSize(PANEL_WIDTH, PANEL1_HEIGHT);
		exitPanel.setBackground(Color.RED);
		totalGUI.add(exitPanel);

		exitButton = new JButton("Exit");
		exitButton.setLocation(DEFAULT_SPACE, DEFAULT_SPACE);
		exitButton.setSize(BUTTON_WIDTH*2, BUTTON_HEIGHT);
		exitButton.addActionListener(this);
		exitPanel.add(exitButton);
		return totalGUI;
	}

	// This is the new ActionPerformed Method.
	// It catches any events with an ActionListener attached.
	// Using an if statement, we can determine which button was pressed
	// and change the appropriate values in our GUI.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == redButton) {
			redScoreAmount = redScoreAmount + 1;
			redScore.setText("" + redScoreAmount);
		} else if (e.getSource() == blueButton) {
			blueScoreAmount = blueScoreAmount + 1;
			blueScore.setText("" + blueScoreAmount);
		} else if (e.getSource() == resetButton) {
			redScoreAmount = 0;
			blueScoreAmount = 0;
			redScore.setText("" + redScoreAmount);
			blueScore.setText("" + blueScoreAmount);
		}
	}

	public static void createAndShowGUI() {

		// JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();

		// Create and set up the content pane.
		ButtonDemo demo = new ButtonDemo();
		frame.setContentPane(demo.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
	}
}