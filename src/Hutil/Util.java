package Hutil;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class Util
{
	private static StandardServiceRegistry r;
	private static SessionFactory sf;
	public static SessionFactory getsf()
	{
		if(sf==null)
		{
			Map<String, Object>s=new HashMap<>();
			s.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
			s.put(Environment.USER,"root");
			s.put(Environment.PASS,"root");
			s.put(Environment.URL,"jdbc:mysql://localhost:3306/h6");
			s.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			s.put(Environment.HBM2DDL_AUTO,"update");
			s.put(Environment.SHOW_SQL,"true");
			
			r=new StandardServiceRegistryBuilder().applySettings(s).build();
			
			MetadataSources mds=new MetadataSources(r);
			
			mds.addAnnotatedClassName("Model.Emp");
			mds.addAnnotatedClassName("Model.BankInf");
			
			Metadata md=mds.getMetadataBuilder().build();
			
			sf=md.getSessionFactoryBuilder().build();
		}
		return sf;
	}
}
