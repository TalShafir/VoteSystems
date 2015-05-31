package voting;

import javax.swing.SwingUtilities;

public class VotingClient {
	
	public VotingClient() {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VotingGUI vGui=new VotingGUI();
				vGui.setVisible(true);
				
			}
		});
	}
	
}
