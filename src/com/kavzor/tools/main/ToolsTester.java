package com.kavzor.tools.main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kavzor.tools.file.FileHandler;

public class ToolsTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel checkboxPanel = new JPanel();
		JButton button = new JButton("Who's it gonna be?");
		final JLabel label = new JLabel("Name: ");
		label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		
		final JCheckBox easyAssignment = new JCheckBox("1");
		final JCheckBox hardAssignment = new JCheckBox("2");
		checkboxPanel.add(easyAssignment);
		checkboxPanel.add(hardAssignment);
		
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(button, gbc);
		gbc.gridy = 1;
		panel.add(checkboxPanel, gbc);
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 0, 0, 0);
		panel.add(label, gbc);
		
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileHandler fileHandler = new FileHandler(new File("presentation.txt"), "Names");

				String name = fileHandler.getRandom();
				if(easyAssignment.isSelected()) {
					System.out.println("EASY");
					while(!name.contains("1")) {
						name = fileHandler.getRandom();
					}
				}
				else if(hardAssignment.isSelected()) {
					System.out.println("HARD");
					while(!name.contains("2")) {
						name = fileHandler.getRandom();
						System.out.println(name);
					}
				}
				name = name.replace("2", "").replace("1", "").trim();
				label.setText("Name: " + name);
				
			}
		});
		
		
		//System.out.println("Namn: " + fileHandler.getRandom());
		
		//fileHandler = new FileHandler(new File("presentation.txt"), "Assignments");
		//System.out.println("Uppgift: " + fileHandler.getRandom());
	}
}
