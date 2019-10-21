package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Hutil.Util;
import Model.BankInf;
import Model.Emp;

public class Main
{
	public static void main(String args[])
	{
		SessionFactory sf=Util.getsf();
		
		Session ss=sf.openSession();
		
		BankInf b1=new BankInf();
		b1.setAccno(1564);
		b1.setBname("SBI");
		b1.setIfsc(89964);
		
		BankInf b2=new BankInf();
		b2.setAccno(0215);
		b2.setBname("BOI");
		b2.setIfsc(7864);
		
		Emp e1=new Emp();
		e1.setId(1);
		e1.setBk(b1);
		e1.setName("Avi");

		Emp e2=new Emp();
		e2.setId(2);
		e2.setBk(b2);
		e2.setName("Sandy");
		
		ss.save(e1);
		ss.save(e2);
		
		ss.beginTransaction().commit();
	}
}
