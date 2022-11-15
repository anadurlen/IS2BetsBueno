package adapter;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.ApustuAnitza;
import domain.Registered;
import domain.User;

public class UserAdapter extends AbstractTableModel {
	private User user;
	private Vector<ApustuAnitza> apuestas;
	private String[] columNames = new String[] {"Event", "Question", "Event Date", "Bet (€)"};
	
	public UserAdapter(User user) {
		apuestas = ((Registered) user).getApustuAnitzak();
		this.user = user;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public int getRowCount() {
		return apuestas.size();
	}
	
	
	public String getColumnName(int colum) {
		return columNames[colum];
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return (Object)apuestas.get(rowIndex).getApustuak();
			case 1: return (Object)apuestas.get(rowIndex);
			case 2: return (Object)apuestas.get(rowIndex).getData();
			case 3: return (Object)apuestas.get(rowIndex).getBalioa();
		}
		return null;
	}
}


