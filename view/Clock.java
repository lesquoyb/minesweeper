package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JPanel {
	
	
	private JLabel minutes;
	private JLabel secondes;
	private JLabel colon;
	private Font font;
	private JButton reload;

	
	
		public Clock(){
			super();
			
			try {
			     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/fonts/DS-DIGI.TTF")));
			     font = new Font("DS-Digital",Font.PLAIN,35);
			     
			} catch (IOException|FontFormatException e) {
			     font = new Font(Font.SANS_SERIF,Font.PLAIN,35);
			}
			reload = new JButton();
			reload.setIcon(new ImageIcon("src/resources/images/reload.png"));
			reload.setFocusable(false);
			
			JPanel space = new JPanel();
			space.setPreferredSize(new Dimension(150, 20));
			//reload.addActionListener();
			
			minutes = new JLabel("00");
			secondes = new JLabel("00");
			colon = new JLabel(":");
			
			minutes.setFont(font);
			secondes.setFont(font);
			colon.setFont(font);
			
			minutes.setForeground(Color.blue);
			secondes.setForeground(Color.blue);
			colon.setForeground(Color.blue);
			
			this.setLayout(new FlowLayout());
			this.add(minutes);
			this.add(colon);
			this.add(secondes);
			this.add(space);
			this.add(reload);
			this.setVisible(true);
			
			
		}

		
		public void setSeconds(){
			
		}
		
		public void setMinutes(){
			
		}
}
