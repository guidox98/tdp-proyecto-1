package launcher;

import entities.Student;
import gui.SimplePresentationScreen;


public class Launcher {	
	
	
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		int id = 114691;
		String apellido = "Pierdominici";
		String nombre = "Guido";
		String mail = "guidopier@live.com.ar";
		String githubURL = "https://github.com/guidox98";
		String foto = "/images/ImagenGuido.png";
		Student estudiante = new Student(id, apellido, nombre, mail, githubURL,foto);
		
       
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	 SimplePresentationScreen sps = new SimplePresentationScreen(estudiante);
            	 sps.setVisible(true);
            }
        });
    }
}