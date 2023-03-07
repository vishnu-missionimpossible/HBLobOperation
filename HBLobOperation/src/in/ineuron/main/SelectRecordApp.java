package in.ineuron.main;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JobSeeker seeker = null;
		FileOutputStream fos = null;
	    FileWriter out = null;
		
		Session session = HibernateUtil.getSession();
		int id =1;
		try {
			 
			if(session!=null) {
			   seeker = session.get(JobSeeker.class, 1);	
			   
			   if (seeker != null) {
				    fos=new FileOutputStream("store/photo.jpg");
				    fos.write(seeker.getPhoto());
				    out = new FileWriter("store/resume.txt");
				    out.write(seeker.getResume());
				    
				    fos.flush();
				    out.flush();
				    System.out.println("LOB's are retrived...");
				    System.out.println(seeker);
			    }else {
			    	System.out.println("Record not available for the given id: "+id);
				}
		  
			}
			
		} catch (HibernateException e) {
			// TODO: handle exception
		     e.printStackTrace();
		}

	}

}
