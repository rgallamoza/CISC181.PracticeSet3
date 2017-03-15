package pkgLibrary;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
	
	@Test
	public void TestGetBook() throws BookException {
	
	Catalog cat = ReadXMLFile();
	
	assertEquals(Catalog.GetBook(cat,"bk101").equals(cat.getBooks().get(0)),true);
	
	}

}
