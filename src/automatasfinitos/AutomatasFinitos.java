package automatasfinitos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author J.Daniel Ramirez
 */

public class AutomatasFinitos {

    Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        Map<Object, List<Object>> maps = new HashMap<Object, List<Object>>();
        ArrayList<Object> keys = new ArrayList<>();
        ArrayList<Object> arrayQ = new ArrayList<>();
        ArrayList<Object> cadenas = new ArrayList<>();
        boolean flag = true;
        int n1 =0;
        int eFinal = 0;
        
        Scanner input = new Scanner(System.in);
        do{
            Validacion.menu();
            do{
            try{
            
            n1 = Integer.parseInt(input.nextLine());
                    switch (n1) {
                        case 1:
                            //Ingresar automata
                            maps.clear();
                            keys.clear();
                            arrayQ.clear();
                            eFinal = inputCadena((HashMap) maps, keys,arrayQ);                            
                            break;
                        case 2:
                            cadenas.clear();
                            //Validar palabra en automata
                            Validacion.validarCadena((HashMap) maps, cadenas, eFinal, arrayQ);
                            break;
                        case 3:
                            //Mostrar automata
                            mapear((HashMap) maps);
                            break;                            
                        case 4:
                            //Salir del sistema
                            System.exit(0);
                            break;
                        case 5:
                            //PRUEBA - TEST
                            mostrar((HashMap) maps, keys);
                            break;
                    }

                } catch (java.lang.NumberFormatException ex) {
                    flag = false;
                    System.out.println("Debe ingresar una opcion valida");
                    //System.out.println("Erro al ingresar caracter no valido " + ex);
                }
            }while (flag == false);           
        } while (n1 != 4);         
        
    }

    
    public static int inputCadena(HashMap mapp, ArrayList<Object> keys, ArrayList<Object> arrayQ){        
        List<Object> list = new ArrayList<Object>();    
        int eFinal = 0;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        int n1 = 0,n2 = 0, n3=0;
        Object cadenas = null;
        Object key = null;
        
        do {
            flag = true;
            try {
                System.out.print("Cuantos simbolos{E} contiene su automata: ");
                n1 = Integer.parseInt(input.nextLine());
            } catch (java.lang.NumberFormatException ex) {
                flag = false;
                //System.out.println("Erro al ingresar caracter no valido " + ex);
            }
        } while(Validacion.validacionNumero(String.valueOf(n1))==false || flag==false);
         
        do {
            flag = true;
            try {
                System.out.print("Cuantos estados{q} contiene su automata: ");
                n2 = Integer.parseInt(input.nextLine());
                for (int i = 0; i < n2; i++)
                    arrayQ.add(i);                                
                if(Validacion.nombrarEstados(arrayQ)){
                    System.out.println("ESTADOS DEFINIDOS: ");
                    int j = 0;
                    for (Object state : arrayQ) {
                        System.out.println("[q"+(j+1)+"]:" + state);
                        j++;
                    }
                }else{
                    System.out.println("ESTADOS DEFINIDOS GENERICAMENTE");
                    for (Object state : arrayQ) {
                        System.out.println("["+state+"]: " + state);
                    }
                }
                
            } catch (java.lang.NumberFormatException ex) {
                flag = false;
                //System.out.println("Erro al ingresar caracter no valido " + ex);
            }
        } while(Validacion.validacionNumero(String.valueOf(n1))==false || flag==false);                                                                                 
        
        //Ingrese el indice del estado final    
        System.out.print("Ingrese el indice del conjunto de estados finales del automata F={}");
        eFinal = Integer.parseInt(input.nextLine());
            
        for (int i = 0; i < n1; i++) {       
            List<Object> pl = new ArrayList<Object>();    
            key = null;
            cadenas = null;
            pl.clear();
            System.out.print("Ingrese su simbolo[" + (i+1) + "]: ");
            key = input.nextLine();
            keys.add(key);
            for (int j = 0; j < n2; j++) {
                System.out.print("ingrese el estado[ q"+(j+1)+"] para su simbolo [" + key.toString() + "] : ");
                cadenas = input.nextLine();
                pl.add(cadenas);
            }                        
            list = pl;
            mapp.put(key, list);
        }        
        mapear((HashMap) mapp);        
        return eFinal;
    }
    
    public static void mapear(HashMap mapp){    
        for (Object i : mapp.keySet()) {
            System.out.println("Simbolo [" + i + "] -> Estados: q" + mapp.get(i));            
        }
        System.out.println("\n");
    }    
    
    public static void mostrar(HashMap<Object, List<Object>> mapp, ArrayList<Object> array){
//        
        for (Object i : mapp.keySet()) {
            if (i.equals("a")) {
                System.out.println("Simbolo [" + i + "] -> Estados: q" + mapp.get(i).get(0));            
            }
        }
//        for (Object object : array) {
//            System.out.println("Espacio " + object.toString());
//        }

//            System.out.println("Espacio N." + array.get(0));
    }
    
    public static void automata(HashMap<Object, List<Object>> mapp,ArrayList<Object>  cadena, int eFinal, ArrayList<Object> estadosQ){
        boolean flag = false;
        boolean flagRed = false;
        
        int eActual = 0;
        int esFinal = eFinal -1; 
        int dato;
        
        int i =0; //inicio i para ciclos
        //Do_ while, hasta que la cadenaArray<Objetos> se acabe || hasta que tenga flag = true
        do{                                 
            //Primero utiliza el primer objeto de la cadena ingresada = llave
            for (Object llave : mapp.keySet()) {
                //compara cada objeto del arrayList de llaves con la llave ingresada
//                if (cadena.contains(llave)) {
                    if (cadena.get(i).equals(llave)) {
                        //si cuentra el dato ingresado dentro del ArrayList de llaves ingresamos
                        //F(estado inicial, cadena)
                        //F(einicial, dato)
                        if (eActual == 0) {
                            System.out.println("Estado inicial: " + estadosQ.get(eActual));
                        }
                        dato = Integer.parseInt((String) mapp.get(llave).get(eActual));
                        System.out.println("[Estado, Simbolo] [ " + estadosQ.get(eActual) + " , " + llave + "]: ->  " + estadosQ.get(dato - 1));
                        eActual = Integer.parseInt((String) mapp.get(llave).get(eActual));
                        eActual = eActual - 1;

                        if (esFinal == eActual && i == (cadena.size() - 1)) {
                            //Si llegamos al estado final
                            System.out.println("COMPROBACION FINALIZADA");
                            flag = true;
                        } else if (esFinal != eActual && i == (cadena.size() - 1)) {
                            System.out.println("COMPROBACION FINALIZADA / NO VALIDO");
                            flag = true;
                        } else {
                            System.out.println("AUTOMATA CONTINUA-INGRESO VALIDO");
                        }
                        break;
                    }
//                } else {//fin if flagRed
//                    System.out.println("***INGRESO SIMBOLOS NO RECONOCIDOS POR EL AUTOMATA");
//                    flag = true;
//                    break;
//                }
            }                                
            i++;            
        }while(flag==false);
        
        if(flag==false) System.out.println("AUTOMATA NO ACEPTADO - VALORES NO RECONOCIDOS");
        if(flag==true && esFinal==eActual)System.out.println("RESPUESTA DEL AUTOMATA: CADENA "+ cadena.toString() +"  ES VALIDA - ESTADO FINAL ALCANZADO");
        if(flag==true && esFinal!=eActual)System.out.println("RESPUESTA DEL AUTOMATA: CADENA "+ cadena.toString() +"NO ES VALIDA - ESTADO FINAL NO ALCANZADO");        
        
    }
    
    
}
