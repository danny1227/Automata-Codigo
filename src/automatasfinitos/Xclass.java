package automatasfinitos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author J.Daniel Ramirez
 */

public class Xclass {
    
    
    public static void main(String[] args) {
        ArrayList<Object> listaK = new ArrayList<Object>();
                Scanner input = new Scanner(System.in);
                
        listaK.add("a");
        listaK.add("b");
        listaK.add("c");
        
        ArrayList<Object> listaS = new ArrayList<Object>();
                
        listaS.add("b");
        listaS.add("b");
        listaS.add("c");
        listaS.add("d");
        listaS.add("a");
        
        //System.out.println("La lista de estados "+ lista.toString() +"  ");
        
        if(Validacion.allItems(listaK, listaS)){
            System.out.println("Todos los elementos de la sentencia son llaves reconocidas \n " + listaS.toString() );
        }else{
            System.out.println("Hay elementos que no se reconocen\n " + listaS.toString());
        }
                //verify if allItems of Array are equals
//if ((lista.stream().distinct().count() <= 1) && lista.size()%2==0 ) {
//                    System.out.println("No se puede, numero par y duplicado? " + lista.toString());
//        }
        
//        String[] parts = String.valueOf(lista.get(2)).split("-");       
//        if(parts.length>1){    
//            System.out.println("Estado doble");
//                    System.out.println("String: " +parts[0] );
//                     System.out.println("String: " +parts[1] );
//        }else{            
//            System.out.println("El estado solo contiene uno");
//            System.out.println("Estado " + lista.get(2));
//        }
//        System.out.print("ingrese el estado[ qx] para su simbolo [] : ");
//        obj1 = input.nextLine();
//                      System.out.println("String: " +parts[2] );

    }
           
    
}
