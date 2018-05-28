package com.tecsup.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class EmployeeDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOTest.class);

	@Autowired
	private EmployeeDAO employeeDAO;

	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	@Test
	public void testFindEmployeeByMany() {
		try {
			//
			Employee emp = employeeDAO.findEmployeeByMany("Fernanda", "Alvarado", 19);
	
			Assert.assertNotNull(emp);

			Assert.assertEquals("aalvarado2", emp.getLogin());
			Assert.assertEquals("123", emp.getPassword());
			Assert.assertEquals(3000, emp.getSalary());
			Assert.assertEquals(19, emp.getAge());
			logger.info(emp.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
		
	}

	//@Test
	//public void testCreateEmployee() {

		//logger.info("--");
		//
		//String LOGIN = "aalvarado2";
		//logger.info(LOGIN);
		//String PWD = "123";
		//String FIRSTNAME = "Fernanda";
		//String LASTNAME = "Alvarado";
		//int SALARY = 3000;
		//int AGE = 19;
		//int DEPT_ID = 14;

		//try {
		//	//
		//	employeeDAO.create(LOGIN, PWD, FIRSTNAME, LASTNAME, SALARY, AGE, DEPT_ID);

		//	//
		//	Employee emp = employeeDAO.findEmployeeByLogin(LOGIN);

		//	Assert.assertEquals(PWD, emp.getPassword());
		//	Assert.assertEquals(FIRSTNAME, emp.getFirstname());
		//	Assert.assertEquals(LASTNAME, emp.getLastname());
		//	Assert.assertEquals(SALARY, emp.getSalary());
		//	Assert.assertEquals(AGE, emp.getAge());
			
		//} catch (DAOException e) {
		//	fail(e.getMessage());
		//} catch (EmptyResultException e) {
		//	fail(e.getMessage());
		//}

	//}

	
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
}
