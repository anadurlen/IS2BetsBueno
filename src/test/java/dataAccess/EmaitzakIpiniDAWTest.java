package dataAccess;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import configuration.ConfigXML;
import configuration.UtilDate;
import domain.ApustuAnitza;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Team;
import exceptions.EventNotFinished;

public class EmaitzakIpiniDAWTest {
	
	/*
	Team t1 = new Team("Atletico");
	Team t2 = new Team("Athletic");
	
	Event e1 = new Event(3, "Atletico-Athletic", UtilDate.newDate(2024,01,17), t1, t2);
	Event e2 = new Event(2, "Atletico-Athletic", UtilDate.newDate(2021,01,17), t1, t2);
	
	Question q1 = new Question("¿Quién ganara?", 1.0, e1);
	Question q2 = new Question("¿Quién marcara primero?", 2.0, e2);
	Question q3 = new Question("¿Quién marcara primero?", 2.0, e1);
	Question q4 = new Question("¿Quién marcara ultimo?", 2.0, e1);
	
	Quote quote1 = new Quote(10.0, "X", q1);
	Quote quote2 = new Quote(20.0, "2", q2);
	Quote quote3 = new Quote(50.0, "2", q1);
	Quote quote4 = new Quote(20.0, "2", q3);
	Quote quote5 = new Quote(5.0, "2", q4);
	Quote quote6 = new Quote(2.0, "1", q4);
	
	Registered r1 = new Registered("andrea", "123", 1111);
	ApustuAnitza aa1 = new ApustuAnitza(r1, 5.0);
	Apustua a1 = new Apustua(aa1, quote3);
	
	Registered r2 =new Registered("registered", "123", 1234);
	ApustuAnitza aa2 = new ApustuAnitza(r2, 2.0);
	Apustua a2 = new Apustua(aa2, quote4);
	
	Registered r3 = new Registered("markel", "123", 1111);
	ApustuAnitza aa3 = new ApustuAnitza(r3, 40.0);
	Apustua a3 = new Apustua(aa3, quote5);
	
	Apustua a4 = new Apustua(aa3, quote6);
	
	*/
	
	static DataAccess sut  =  new DataAccess();
	
	
	@Before
	public void setUp() throws Exception {
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() {
		fail("Not yet implemented");
	}

	@Test(expected = EventNotFinished.class)
	public void testEmaitzakIpini1() {
		try {
			sut.EmaitzakIpini(quote2);
			fail("No deberia de llegar.");
		} catch (EventNotFinished e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEmaitzakIpini2() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testEmaitzakIpini3() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testEmaitzakIpini4() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testEmaitzakIpini5() {
		fail("Not yet implemented");
	}


}
