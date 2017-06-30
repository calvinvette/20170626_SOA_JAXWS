import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.trivera.costservice.generated.CostService;
import com.trivera.costservice.generated.CostService_Service;

public class CostClient {

	public static void main(String[] args) {
		String result = JOptionPane.showInputDialog("Number of items to compute cost for:");
		CostService svc = new CostService_Service().getCostServiceSOAP();
		JOptionPane.showMessageDialog(null, "Cost is: " + svc.calculateCost(Float.parseFloat(result)));
	}

}
