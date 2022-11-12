

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
		
		
		
		descripcion = null;
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Tennis";
		
		try {
			dt.gertaerakSortu(descripcion, date, s);
		}
		catch(Exception e) {
			assertTrue(true);
			System.out.println("La descripción no puede ser null");
		}
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
	
	
	@Test
	public void test3() {
		
		boolean esperado = false;
		
		descripcion = "Casper Ruud-Alexander Zverev";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = " ";
		
		boolean res = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(esperado, res);

		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		System.out.println("El sport es null (" + descripcion + ", " + date.toString() + ", " + s + ")");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date.toString() + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
			
	}
	
	
	@Test
	public void test4() {
		
		boolean esperado = false;
		
		descripcion = "Casper Ruud-Alexander Zverev";
		date = null;
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
		
		System.out.println("La fecha es null (" + descripcion + ", " + date.toString() + ", " + s + ")");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date.toString() + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
				
	}
	
	
	@Test
	public void test5() {
		
		boolean expected = false;
		
		descripcion = "Real Madrid-Barcelona";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Balonmano";
		
		boolean result = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(expected, result);
				
		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		System.out.println("sport " + s +" no es un Sport");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
				
	}
	
	
	@Test
	public void test6() {
		
		boolean expected = false;
		
		descripcion = "Real Madrid-Barcelona";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)-3), 17);
		s = "Balonmano";
		
		boolean result = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(expected, result);
				
		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		System.out.println("La fecha no puede ser anterior a la actual");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
				
	}
	
	
	
	

}