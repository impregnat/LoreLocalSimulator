import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private BufferedImage buffer;
	private BufferedImage buf;
	private ArrayList<String[]> questions;
	
	
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
	private JLabel label_1;
	private JLabel label_2;
	private int qnumber = 0;
	private int countError = 0;
	private int t = 0;
	private Timer timerLabel = new Timer(1000, new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			t++;
			int min = t/60;
			int sec = t % 60;
			label_1.setText(((min>9) ? "" : "0")  + min+":" + ((sec>9)? "" : "0")+ sec);
			
		}
		
	});

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		String[][] questions = {
			{"������� ��������� �����", "#256600"},
			{"� ����� ������ ������������� ����������� ����� �����������?", "#a70000"},
			{"� ����� ������ ��������� ����� ���?", "#2af3c5"},
			// � ���� ���� �� �������? {"������� �����, � ������� �� ���������", "#a70000"},
			{"� ����� ������ �������� ������� ���������, ����� ��� ������� ���������� �������� ����������?", "#96673a"},
			{"������� �����, � ������� ��������� ����� ������","#256600"},
			{"� ����� ������, �������� ���������, ������������ ����� ������� ����� ����������� ����?", "#2c9b4e"},
			{"������� �����,� ������� ��������� ������� ����(1932 �.)","#a465be"},
			{"����� ��������� ���������","#43436d"},
			{"� ����� ������ ������������� �����, ��������� � ����� ���������� ��������-��������?" ,"#c3f30c"}
		};
		this.questions = new ArrayList<String[]>();
		for(String[] q:questions){
			this.questions.add((int)(Math.random() * this.questions.size()),q);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 587);
		setTitle("��������� ���������");
		setResizable(false);
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(buf, 5, 0, null );
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		final ChoicePanel choicepanel = new ChoicePanel();
		choicepanel.button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.remove(contentPane);
				MainFrame.this.setContentPane(contentPane);
				label_2.setText("<html><body><div style=\"padding:3px; border:1px solid black; background-color:white; height:20px; width: 600px; text-align:center;\">" + MainFrame.this.questions.get(qnumber)[0] + "</div></body></html>");
				MainFrame.this.revalidate();
				timerLabel.start();
			}
		});
		final TrainPanel trainpanel = new TrainPanel();
		choicepanel.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.remove(choicepanel);
				MainFrame.this.setContentPane(trainpanel);
				MainFrame.this.revalidate();
			}
		});
		trainpanel.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.remove(trainpanel);
				MainFrame.this.setContentPane(choicepanel);
				MainFrame.this.revalidate();
			}
		});
		
		final MenuPanel menupanel = new MenuPanel();
		setContentPane(menupanel);
		menupanel.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.this.remove(menupanel);
				MainFrame.this.setContentPane(choicepanel);
				MainFrame.this.revalidate();
			}
		});
		

		try{
			buffer = ImageIO.read(new File("fon.png"));
		} catch (IOException e1) {
		}
		try{
			buf = ImageIO.read(new File("fon.png"));
		} catch (IOException e1) {
		}
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((e.getX() >= 5) && (e.getX() <= 800) && (e.getY() <= 513)) {
					Color c = new Color(buffer.getRGB(e.getX() - 5, e.getY()));
					String red = Integer.toHexString(c.getRed());
					String green = Integer.toHexString(c.getGreen());
					String blue = Integer.toHexString(c.getBlue());
					String color = "#" + ((red.length() < 2 ) ? "0": "") + red
							+((green.length() < 2) ? "0" : "") + green
							+((blue.length() < 2) ? "0" : "") + blue;
					for (int i = 0; i < regionInfo.length; i++) {
						if (color.equals(regionInfo[i][1])) {
							if (color.equals(MainFrame.this.questions.get(qnumber)[1])) {
								qnumber++;
								if (qnumber == MainFrame.this.questions.size()) {
									WinPanel wp = new WinPanel();
									MainFrame.this.remove(contentPane);
									MainFrame.this.setContentPane(wp);
									wp.label.setText("������ �� " + label_1.getText());
									wp.label_2.setText("���������� ������: " + countError);
									MainFrame.this.revalidate();
								} else {
									JOptionPane.showMessageDialog(null, "�������: "
											+ regionInfo[i][0]
											+ "\n��� ���������� �����!", "���������� �����", JOptionPane.ERROR_MESSAGE,new ImageIcon("galocka.png"));
									label_2.setText("<html><body><div style=\"padding:3px; border:1px solid black; background-color:white; height:20px; width: 600px; text-align:center;\">" +MainFrame.this.questions.get(qnumber)[0] + "</div></body></html>");
								}
							} else {
								countError++;
								JOptionPane.showMessageDialog(null, "�������: "
										+ regionInfo[i][0]
										+ "\n��� ������������ �����!", "������", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionListener() {
			
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
					for (int i = 0; i < regionInfo.length; i++) {
						if (color.equals(regionInfo[i][1])) {								
							for(int x = 0; x < buf.getWidth(); x++) {
								for(int y = 0; y < buf.getHeight(); y++){
									if(buf.getRGB(x, y) == c.getRGB()){
										buf.setRGB(x, y, new Color(255,255,255).getRGB());
										
									}
								}
							}
						}
					}
				}	
				contentPane.repaint();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO ������������� ��������� �������� ������
				
			}
		});
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.setLayout(null);
		
		label_1 = new JLabel("00:00");
		label_1.setBounds(10, 10, 58, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(0, 510, 803, 30);
		contentPane.add(label_2);
	}
}
