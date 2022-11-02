

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import configuration.UtilDate;
import dataaccess.DataAccess;
import domain.Event;

public class GertaerakSortuDAWTest {

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
	public void test2() {
		
		boolean expected = true;
		
		descripcion = "Casper Ruud-Alexander Zverev";
		date = UtilDate.newDate(today.get(Calendar.YEAR) + 1, (today.get(Calendar.MONTH)+1), 2);
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
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
			
	}
	/*
	 * Este test igual no es necesario porque ya hay 1005 de cobertura
	 * 
	@Test
	public void test3() {
		
		boolean expected = true;
		
		descripcion = "Casper Ruud-Alexander Zverev";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Tennis";

		boolean result = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(expected, result);
		
		if (!deleted)
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
			
	}*/
	@Test
	public void test4() {
		
		boolean expected = false;
		
		descripcion = "Djokovic-Federer";
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Tennis";
		
		dt.gertaerakSortu(descripcion, date, s);
		boolean result = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(expected, result);
				
		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date + ", " + s + ")");
		else
			System.out.println("Evento no borrado (" + descripcion + ", " + date + ", " + s + ")");
			
	}
	
	
	@Test
	public void test5() {
		
		boolean expected = false;
		
		descripcion = null;
		date = UtilDate.newDate(today.get(Calendar.YEAR), (today.get(Calendar.MONTH)+1), 17);
		s = "Tennis";
		
		dt.gertaerakSortu(descripcion, date, s);
		boolean result = dt.gertaerakSortu(descripcion, date, s);
		
		assertEquals(expected, result);
				
		for (Event ev : dt.getEvents(date)) {
			if (ev.getDescription().equals(descripcion)) {
				dt.gertaeraEzabatu(ev);
				deleted = true;
				break;
			}
		}
		
		System.out.println("la descripción no puede ser null");
		
		if (deleted)
			System.out.println("Evento borrado (" + descripcion + ", " + date + ", " + s + ")");
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
	public void test6() {
		
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
	public void test7() {
		
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


	


