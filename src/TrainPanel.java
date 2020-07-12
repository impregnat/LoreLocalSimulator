import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;


public class TrainPanel extends JPanel {

	private BufferedImage buffer;
	private BufferedImage buf;
	private JLabel label_2;
	private String[][] regionInfo = {
			{"������������ �����", "#c3f30c"},
			{"����������� �����", "#2af3c5"},
			{"��������� �����", "#a465be"},
			{"������������ �����", "#673c22"},
			{"������� �����", "#a70000"},
			{"���������� �����", "#256600"},
			{"������������� �����", "#0e6150"},
			{"��������� �����", "#1c153a"},
			{"���������-��������� �����", "#b61faa"},
			{"���������� �����", "#ffff31"},
			{"���������� �����", "#8a8a8a"},
			{"��������� �����", "#6bcb67"},
			{"������ �����", "#96673a"},
			{"��������� �����", "#43436d"},
			{"������������ �����", "#ffa912"},
			{"������������������ �����", "#4e0f47"},
			{"������� �����", "#35d814"},
			{"��������� �����", "#727769"},
			{"���������� �����", "#2c9b4e"},
			{"����������� �����", "#599900"},
			{"���������� �����", "#314153"},	
		};
	public JButton button;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buf, 5, 0, null );
	}
	
	public TrainPanel() {
		try{
			buffer = ImageIO.read(new File("fon.png"));
		} catch (IOException e1) {
		}
		try{
			buf = ImageIO.read(new File("fon.png"));
		} catch (IOException e1) {
		}
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				buf = new BufferedImage(buffer.getWidth(), buffer.getHeight(), buffer.getType());
				buf.getGraphics().drawImage(buffer, 0, 0, null);
				if ((e.getX() >= 5) && (e.getX() <= 800) && (e.getY() <= 513)) {
					Color c = new Color(buffer.getRGB(e.getX() - 5, e.getY()));
					String red = Integer.toHexString(c.getRed());
					String green = Integer.toHexString(c.getGreen());
					String blue = Integer.toHexString(c.getBlue());
					String color = "#" + ((red.length() < 2 ) ? "0": "") + red
							+((green.length() < 2) ? "0" : "") + green
							+((blue.length() < 2) ? "0" : "") + blue;
					label_2.setText("<html><body><div style=\"padding:3px; border:1px solid black; background-color:white; height:20px; width: 620px; text-align:center;\">" + "</div></body></html>");
					for (int i = 0; i < regionInfo.length; i++) {
						if (color.equals(regionInfo[i][1])) {								
							for(int x = 0; x < buf.getWidth(); x++) {
								for(int y = 0; y < buf.getHeight(); y++){
									if(buf.getRGB(x, y) == c.getRGB()){
										buf.setRGB(x, y, new Color(255,255,255).getRGB());
										
									}
								}
							}
							label_2.setText("<html><body><div style=\"padding:3px; border:1px solid black; background-color:white; height:20px; width: 620px; text-align:center;\">" +regionInfo[i][0] + "</div></body></html>");
						}
					}
				}	
				TrainPanel.this.repaint();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO ������������� ��������� �������� ������
				
			}
		});
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setLayout(null);
		label_2 = new JLabel();
		label_2.setText("<html><body><div style=\"padding:3px; border:1px solid black; background-color:white; height:20px; width: 620px; text-align:center;\">" + "</div></body></html>");
		label_2.setBounds(0, 510, 820, 30);
		add(label_2);
		
		button = new JButton("\u0412\u0435\u0440\u043D\u0443\u0442\u044C\u0441\u044F");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBounds(26, 30, 136, 35);
		add(button);

	}
}
