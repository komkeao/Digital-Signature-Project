package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class FileController
 */
@WebServlet("/FileController")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 5000 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;

	   public void init( ){
	      // Get the file location where it would be stored.

	       filePath =  getServletContext().getRealPath("/WEB-INF/");  
	   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   // Check that we have a file upload request
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );

	      
	      
	      if( !isMultipart )
	      {
	         out.println("No Upload This Time");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      
	      
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
   
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("d://"));

	      // Create a new file upload handler
	      ServletFileUpload up = new ServletFileUpload((FileItemFactory) factory);
	      
	      

	      up.setSizeMax( maxFileSize );

	      try{ 

	      List fileItems = up.parseRequest(request);
		

	      Iterator element = fileItems.iterator();

	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Servlet upload</title>");  
	      out.println("</head>");
	      out.println("<body>");
	      while ( element.hasNext () ) 
	      {
	        FileItem fi = (FileItem)element.next();
	         if ( !fi.isFormField () )	
	         {
	            
	            String fileName = fi.getName();
	            init();
	            if( fileName.lastIndexOf("\\") >= 0 ){
	               file = new File( filePath+"/"+ fileName.substring( fileName.lastIndexOf("\\"))) ;
	            }else{
	               file = new File(filePath+"/"+fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	            }
	            
	          
	            fi.write( file ) ;
	            out.println("Uploaded Filename: " + fileName + "<br>"+ filePath);
	         }
	      }
	      out.println("</body>");
	      out.println("</html>");
	   }catch(Exception ex) {
	       System.out.println(ex);
	   } 
	   
	}

}
