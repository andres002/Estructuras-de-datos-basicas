package ArbolBD;

import java.io.Serializable;
public class ArbolB implements Serializable{
    class Nodo implements Serializable{
        Customers info;
        Nodo izq, der;
      }
      Nodo raiz;

      public ArbolB() {
          raiz=null;
      }
      
      public void insertar (Customers info)
      {
          Nodo nuevo;
          nuevo = new Nodo ();
          nuevo.info = info;
          nuevo.izq = null;
          nuevo.der = null;
         
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, reco;  //reco se utiliza en toso el programa para recorrer el arbol
              reco = raiz;
              while (reco != null)     // hasta encontrar un lugar vacio, respetando el orden
              {
              	
                  anterior = reco;
                  //System.out.println("1. "+info.getCompanyName());
                  //System.out.println("2. "+reco.info.getCompanyName());
                  if (info.getCompanyName().compareTo(reco.info.getCompanyName())<0){
                      reco = reco.izq;
                      //System.out.println("hola");
                  }

                  else{
                      reco = reco.der;
                      //System.out.println("adios");
                  }
              }
              if (info.getCompanyName().compareTo(anterior.info.getCompanyName())<=0)     // de acuerdo a si es mayor o menor se coloca a la izq o der
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      private void preOrder (Nodo reco)
      {
          if (reco != null)
          {
             reco.info.Imprimir();
              preOrder (reco.izq);
              preOrder (reco.der);
          }
      }

      public void preOrder ()
      {
          preOrder (raiz);
          System.out.println();
      }

      private void inOrder (Nodo reco)
      {
          if (reco != null)
          {    
              inOrder (reco.izq);
              reco.info.Imprimir();
              inOrder (reco.der);
          }
      }

      public void inOrder ()
      {
          inOrder (raiz);
          System.out.println();
      }


      private void postOrder (Nodo reco)
      {
          if (reco != null)
          {
              postOrder (reco.izq);
              postOrder (reco.der);
              reco.info.Imprimir();
          }
      }


      public void postOrder ()
      {
          postOrder (raiz);
         // System.out.println();
      }

    /*  public static void main (String [] ar)
      {
          ArbolB abo = new ArbolB ();
          abo.insertar (100);
          abo.insertar (50);
          abo.insertar (25);
          abo.insertar (75);
          abo.insertar (150);
          System.out.println ("Impresion preOrder: ");
          abo.preOrder ();
          System.out.println ("Impresion inOrder: ");
          abo.inOrder ();
          System.out.println ("Impresion postOrder: ");
          abo.postOrder ();        
      }  */    
}