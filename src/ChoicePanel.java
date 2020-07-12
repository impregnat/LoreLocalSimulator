import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;


public class ChoicePanel extends JPanel {
	public JButton button_1;
	public JButton button;

	/**
	 * Create the panel.
	 */
	public ChoicePanel() {
		setBackground(Color.CYAN);
		setForeground(Color.BLACK);
		setLayout(null);
		
		button = new JButton("\u041E\u0431\u0443\u0447\u0430\u044E\u0449\u0438\u0439");
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(178, 126, 159, 34);
		add(button);
		
		button_1 = new JButton("\u0422\u0435\u0441\u0442\u0438\u0440\u0443\u044E\u0449\u0438\u0439");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(497, 126, 158, 34);
		add(button_1);
		
		JLabel label = new JLabel("\u0412\u044B\u0431\u043E\u0440 \u0440\u0435\u0436\u0438\u043C\u0430");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(330, 54, 183, 27);
		add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("gerbIv.png"));
		lblNewLabel.setBounds(178, 191, 477, 357);
		add(lblNewLabel);

	}
}
