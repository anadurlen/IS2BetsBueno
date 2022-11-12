import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataaccess.DataAccess;
import domain.Event;
import domain.Team;
import exceptions.EventFinished;

public class GertaerakSortuMockIntTest {
	
	@Mock
	DataAccess da=Mockito.mock(DataAccess.class);
	
	
	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(da);

	Calendar today = Calendar.getInstance();
	String description;
	Date date;
	String sport;
	
	@Before
	public void Initialize() {
		description = null;
		date = null;
		sport = null;
	}
	
	@Test
	public void test1() {
		try {
			description = "Casper Ruud-Alexander Zverev";
			date = UtilDate.newDate(today.get(Calendar.YEAR) + 1, (today.get(Calendar.MONTH)+1), 17);
			sport = "Tennis";
				
			// Mockito.doReturn(true).when(da.mismaDescripcion(description, date));
			// Mockito.doReturn(true).when(da.sportIsNull(sport));
			
			Mockito.doReturn(false).when(da).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
				
			try {
				boolean res = sut.gertaerakSortu(description, date, sport);
				assertEquals(false, res);
			}catch (Exception e){
				e.printStackTrace();

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void test2() {
		
		try {
			description = null;
			date = UtilDate.newDate(today.get(Calendar.YEAR) + 1, (today.get(Calendar.MONTH)+1), 17);
			sport = "Tennis";
				
			// Mockito.doReturn(false).when(da.mismaDescripcion(description, date));
			// Mockito.doReturn(true).when(da.sportIsNull(sport));
			
			Mockito.doReturn(false).when(da).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
				
			try {
				boolean res = sut.gertaerakSortu(description, date, sport);
				assertEquals(false, res);
			}catch (Exception e){
				e.printStackTrace();

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		
		try {
			description = "Casper Ruud-Alexander Zverev";
			date = UtilDate.newDate(today.get(Calendar.YEAR) + 1, (today.get(Calendar.MONTH)+1), 17);
			sport = null;
				
			// Mockito.doReturn(true).when(da.mismaDescripcion(description, date));
			// Mockito.doReturn(false).when(da.sportIsNull(sport));
				
			try {
				boolean res = sut.gertaerakSortu(description, date, sport);
				assertEquals(false, res);
			}catch (Exception e){
				e.printStackTrace();

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() {
		
		try {
			description = "Casper Ruud-Alexander Zverev";
			date = UtilDate.newDate(today.get(Calendar.YEAR) + 1, (today.get(Calendar.MONTH)+1), 17);
			sport = "Balonmano";
				
			// Mockito.doReturn(true).when(da.mismaDescripcion(description, date));
			// Mockito.doReturn(false).when(da.sportIsNull(sport));
				
			try {
				boolean res = sut.gertaerakSortu(description, date, sport);
				assertEquals(false, res);
			}catch (Exception e){
				e.printStackTrace();

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test5() {
		
		try {
			description = "Casper Ruud/Alexander Zverev";
			date = UtilDate.newDate(today.get(Calendar.YEAR) + 1, (today.get(Calendar.MONTH)+1), 17);
			sport = "Tennis";
				
			// Mockito.doReturn(false).when(da.mismaDescripcion(description, date));
			// Mockito.doReturn(true).when(da.sportIsNull(sport));
				
			try {
				boolean res = sut.gertaerakSortu(description, date, sport);
				assertEquals(false, res);
			}catch (Exception e){
				e.printStackTrace();

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}