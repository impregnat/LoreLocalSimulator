import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class WinPanel extends JPanel {
	public JLabel label;
	public JLabel label_2;

	
	public WinPanel() {
		setBackground(Color.CYAN);
		setForeground(Color.BLACK);
		setLayout(null);
		
		label = new JLabel("\u041F\u043E\u0431\u0435\u0434\u0430 \u0437\u0430 00:00");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(312, 32, 186, 25);
		add(label);
		
		JButton button = new JButton("\u0412\u044B\u0445\u043E\u0434");
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(340, 106, 141, 60);
		add(button);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("gerbIv.png"));
		label_1.setBounds(160, 177, 505, 371);
		add(label_1);
		
		label_2 = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043E\u0448\u0438\u0431\u043E\u043A:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(312, 68, 213, 25);
		label_2.setForeground(Color.BLACK);
		add(label_2);
	}
}
