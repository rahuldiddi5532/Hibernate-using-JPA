package org.jsp.manytomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindStudentByBatchId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Batch id to fetch Student data");
		int bid=sc.nextInt();
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("select b.students from Batch b where b.id=?1");
		q.setParameter(1, bid);
		List<Student> ls=q.getResultList();
		if(ls.size()>0)
		{
			for (Student std : ls) {
				System.out.println(std);
			}
		}
		else
		{
			System.err.println("No Students record found sisce invalid Batch id...!");
		}
		sc.close();
	}
}