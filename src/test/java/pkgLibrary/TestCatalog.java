package pkgLibrary;

import static org.junit.Assert.*;

import java.util.Date;

import javax.sql.rowset.spi.XmlReader;

import org.junit.Test;

import pkgLibrary.Catalog;

import pkgMain.XMLReader;

public class TestCatalog {

	/*@Test
	public void TestGetBook() {
	
	Book b1 = new Book("bk001", "John Brown", "Book 1", "Mystery", 99.95, new Date(), "This is good book.", 79.96);
	Book b2 = new Book("bk002", "Brown Jon", "Book 2", "Comedy", 49.95, new Date(), "This is ok book.", 39.96);
	Book b3 = new Book("bk003", "Bohn Jrown", "Book 3", "Satire", 4.95, new Date(), "This is bad book.", 3.96);
	
	Catalog c1 = new Catalog();
		
	}*/
	
	@Test
	public void TestGetBook() {
	
	Catalog cat = ReadXMLFile();
		
	}

}
