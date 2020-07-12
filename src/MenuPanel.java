import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuPanel extends JPanel {
	
	JButton button;

	public MenuPanel() {
		setBackground(new Color(12,236,254));
		button = new JButton("\u0421\u0442\u0430\u0440\u0442");
		button.setForeground(Color.RED);
		button.setBounds(159, 143, 135, 35);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton button_1 = new JButton("\u0412\u044B\u0445\u043E\u0434");
		button_1.setForeground(Color.RED);
		button_1.setBounds(526, 143, 135, 35);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		setLayout(null);
		add(button);
		add(button_1);
		
		JLabel label = new JLabel("<html><body><center>\u0422\u0440\u0435\u043D\u0430\u0436\u0451\u0440 <br> \u043F\u043E \u043A\u0440\u0430\u0435\u0432\u0435\u0434\u0435\u043D\u0438\u044E \u0438 \u0433\u0435\u043E\u0433\u0440\u0430\u0444\u0438\u0438</center></body></html>");
		label.setForeground(Color.BLACK);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(225, 11, 386, 61);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("gerbIv.png"));
		label_1.setBounds(160, 177, 505, 371);
		add(label_1);

	}
}