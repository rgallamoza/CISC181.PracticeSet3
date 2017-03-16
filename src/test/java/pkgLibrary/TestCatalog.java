package pkgLibrary;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import pkgLibrary.Catalog;

public class TestCatalog {

	/*@Test
	public void TestGetBook() {
	
	Book b1 = new Book("bk001", "John Brown", "Book 1", "Mystery", 99.95, new Date(), "This is good book.", 79.96);
	Book b2 = new Book("bk002", "Brown Jon", "Book 2", "Comedy", 49.95, new Date(), "This is ok book.", 39.96);
	Book b3 = new Book("bk003", "Bohn Jrown", "Book 3", "Satire", 4.95, new Date(), "This is bad book.", 3.96);
	
	Catalog c1 = new Catalog();
		
	}*/

	
	@Test
	public void TestGetBook() throws BookException {
	
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
	
		assertTrue(Catalog.GetBook(cat,"bk101").equals(cat.getBooks().get(0)));
	
	}
	
	@Test(expected = BookException.class)
	public void TestGetBook2() throws BookException {
	
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
	
		assertTrue(Catalog.GetBook(cat,"bk007").equals(cat.getBooks().get(0)));
	
	}

	@Test
	public void TestAddBook() throws BookException {
		
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
		Catalog original = cat;
		
		Book b1 = new Book("bk001", "John Brown", "Book 1", "Mystery", 99.95, new Date(), "This is good book.", 79.96);

		Catalog.AddBook(0,b1);
		
		cat = null;

		basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		assertTrue(cat.getBooks().size()==original.getBooks().size()+1);
		
		try {

			basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(original, file);
			jaxbMarshaller.marshal(original, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	@Test(expected = BookException.class)
	public void TestAddBook2() throws BookException {
		
		Book b1 = new Book("bk101", "Copier McCopy", "How to Steal ID Numbers", "Crime", 66.66, new Date(), "Trust me the id isn't copied.", 53.33);
		
		Catalog.AddBook(0, b1);
		
	}
	
	
	
}
