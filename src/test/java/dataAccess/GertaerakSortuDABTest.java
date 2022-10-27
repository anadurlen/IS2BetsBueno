package dataAccess;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import configuration.UtilDate;
import dataaccess.DataAccess;
import domain.Event;

public class GertaerakSortuDABTest {

	private DataAccess dt = new DataAccess();
	Calendar today = Calendar.getInstance();
	private String descripcion;
	private Date date;
	private String s;
	private boolean deleted;
	
	@Before
	public void initialize() {
		descripcion = "";
		date = null;
		s = "";
		deleted = false;
	}
	
	@Test
	public void test1() {
		boolean expected = true;
		
		descripcion = "Casper Ruud-Alexander Zverev";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Tennis";

		boolean result = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(expected, result);
		
		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		System.out.println("El evento (" + descripcion + ", " + date.toString() + ", " + s + ") creado correctamente");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date.toString() + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
		
		descripcion = "Madrid-Barca";
		date = UtilDate.newDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), 10);
		deleted = false;
		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date.toString() + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
	}
	
	@Test
	public void test2() {
		
		boolean esperado = false;
		
		descripcion = " ";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Tennis";
		
		boolean res = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(esperado, res);

		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		System.out.println("La descripción es null (" + descripcion + ", " + date.toString() + ", " + s + ")");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date.toString() + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
				
	}
}