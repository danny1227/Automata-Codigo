package automatasfinitos;

import static automatasfinitos.AutomatasFinitos.automata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author J.Daniel Ramirez
 */

public class Validacion {
        
        public static boolean validacionInput(String input){
            boolean flag = true;
            //test to GitHub
            for (int i = 0; i < input.length() ; i++) {
                if(Character.isDigit(input.charAt(i))|| Character.isLetter(input.charAt(i))){
                    System.out.println("La cadena es aceptada ~");
                    flag = true;
                }else{
                    flag = false;
                    System.out.println("La cadena NO es aceptada ~ /n Ingrese nuevamente una cadena valida");
                }
            }
            return flag;
        }
        
        public static boolean validacionNumero(String input){
            boolean flag = true;
            
            for (int i = 0; i < input.length(); i++) {
                if(Character.isDigit(input.charAt(i))){
                    flag = true; //Si es true son cadena de numeros
                }else if(Character.isLetter(input.charAt(i))){
                    flag = false; //Si es false son cadena de letras
                }
            }
            
            return flag;
        }
        
        public static boolean nombrarEstados(ArrayList<Object> states){
            Scanner input = new Scanner(System.in);

            boolean flag = true;
            boolean resp = true;
            String rest = "";
            System.out.print("¿Deseas nombrar sus estados? Q={} ");
            rest = input.nextLine();
            if (!rest.equals("Si") && !rest.equals("SI") && !rest.equals("si") && !rest.equals("S")
                    && !rest.equals("s")) {
                flag = false;
                for (int i = 0; i < states.size(); i++) {
                    states.set(i, "q" + String.valueOf((i+1)));
                }
            } else {
                for (int i = 0; i < states.size(); i++) {
                    System.out.print("Nombre del estado [q" + (i + 1) + ":] ");
                    rest = input.nextLine();
                    states.set(i, rest);
                }
            }            
            return flag;
        }
        
        public static void estados(int Efinal){
             Scanner input = new Scanner(System.in);

           
        }
        
        public static void menu(){
            System.out.println(" Ingrese la opcion: ");
            System.out.print(  " 1.Ingresar automata \n"
                             + " 2.Validar palabra \n"
                             + " 3.Mostrar automata \n"
                             + " 4.Salir          :" );
        }
        
        
    public static void validarCadena(HashMap<Object, List<Object>> mapp, ArrayList<Object> cadena, int eFinal, ArrayList<Object> estadosQ){
        Scanner input = new Scanner(System.in);
        Object n1;
        String key="";
        do{
        System.out.print("Digite una entrada para el conjunto de simbolos L={} y el automata: ");
        n1 = input.nextLine();
        if (n1!=null) {
            cadena.add(n1);
        }
        System.out.print("¿Desea ingresar un simbolo más al conjunto L={} ");
        key = input.nextLine();
        }while(key.toLowerCase().contains("si"));
        
        automata(mapp, cadena, eFinal, estadosQ);
        
    }
    //ORIGINAAAL
    public static boolean allItems(ArrayList<Object> keys, ArrayList<Object> cadena){
        boolean flag = true;
            
            for (int i = 0; i < cadena.size(); i++) {
                //recorremos arreglo de setencia verificando que todos los elementos ingresados 
               //se encuentren dentro del arreglo de llaves
                if(keys.contains(cadena.get(i))){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
                
            }
            
        return flag;
    }
    

}
