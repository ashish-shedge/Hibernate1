package test;
import Bean.student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class client {
	public static void main(String[] args) {
	
	
	student st=new student();
	st.setId(113);
	st.setName("abc");
	st.setEmail("abc@gmail.com");
	st.setMarks(500);
	//student object state is transiant
	
	Configuration cfg= new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	Session s=sf.openSession();
	s.save(st);
	//student object state is persistant
	
	s.beginTransaction().commit();
	//student object will be move to the database
	
	s.evict(st);
	//student object will be remove from persistant
	//The garbagde collector can collect ur student object
	}

}
