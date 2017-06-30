import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Currency;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import com.trivera.costservice.generated.CostService;
import com.trivera.costservice.generated.CostService_Service;

import layout.SpringUtilities;

public class CostClientGUI extends JFrame {
	private static CostService svc = new CostService_Service().getCostServiceSOAP();
	private JTextField txtItems = new JTextField(20);
	private JLabel lblItems = new JLabel("Number of Items:");
	private JLabel lblCost = new JLabel("Cost:");
	private JLabel lblResult = new JLabel("$0.00");
	private JPanel pnlMain = new JPanel(new SpringLayout());
	private static DecimalFormat decimalFormat = new DecimalFormat();

	public CostClientGUI() {
		setTitle("Calculate Costs");
		setAutoRequestFocus(true);
		setSize(new Dimension(400, 100));
		pnlMain.add(lblItems);
		lblItems.setLabelFor(txtItems);
		pnlMain.add(txtItems);
		pnlMain.add(lblCost);
		lblCost.setLabelFor(lblResult);
		pnlMain.add(lblResult);
		
		txtItems.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblResult.setText("$" + decimalFormat.format((svc.calculateCost(Float.parseFloat(txtItems.getText())))));
				} catch (NumberFormatException e1) {
					System.out.println("Failed cost calculation: " + e1.getMessage());
				}
			}
		});
		SpringUtilities.makeCompactGrid(pnlMain, 2, 2, 10, 10, 10, 10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(pnlMain);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CostClientGUI();
				
			}
		});
	}

}
