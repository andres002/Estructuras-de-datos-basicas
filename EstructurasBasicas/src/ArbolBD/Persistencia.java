package ArbolBD;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Persistencia{

	public boolean guardar(Object objeto,String nameFile){
		try {
         FileOutputStream fo = new FileOutputStream(nameFile);
         ObjectOutputStream oos = new ObjectOutputStream(fo);
         oos.writeObject(objeto);
         oos.close();
         return true;
      }catch (Exception ex){
      	return false;

      }
	}

	public Object leer(String nameFile){
		 Object deserializedObject=null;
		try{
         FileInputStream fis = new FileInputStream(nameFile);
         ObjectInputStream ois = new ObjectInputStream(fis);  
         deserializedObject = ois.readObject();
         System.out.println("El objeto fue leido correctamente");
         return deserializedObject;
      }
      catch (Exception ex){
      	 System.out.println("El objeto no fue leido correctamente");
         return null;
         
      }
	}



}