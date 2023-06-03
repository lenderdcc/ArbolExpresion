package arboldeexpresiones;

import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String expresion;
        int opcion;
        boolean flag=false;
        ArbolBinario arbol = new ArbolBinario();

        do {
            System.out.println("\n" + "MENU DE OPCIONES"
                    + "\n 1. Insertar Expresion"
                    + "\n 2. Mostrar recorridos"
                    + "\n 3. Salir"
                    + "\n\n Cual opcion desea escoger: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    arbol.raiz = arbol.crearArbolExpresion();
                    System.out.println("Arbol generado exitosamente");
                    flag=true;
                    break;

                case 2:
                    if(flag==false){
                        System.out.println("Primero ingrese una expresion para poder mostrar los recorridos \n");
                        break;
                    }else{
                    do {
                        System.out.println("\n" + "MENU DE RECORRIDOS"
                                + "\n 1. PreOrden"
                                + "\n 2. InOrden"
                                + "\n 3. PosOrden"
                                + "\n 4. Volver"
                                + "\n\n Cual opcion desea escoger: ");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("\n" + "*** PreOrden ***");
                                System.out.print("Recorrido: { ");
                                arbol.raiz.printPreOrder();
                                System.out.println(" }");
                                System.out.println("\n");
                                break;

                            case 2:
                                System.out.println("\n" + "*** InOrden ***");
                                System.out.print("Recorrido: { ");
                                arbol.raiz.printInOrder();
                                System.out.println(" }");
                                System.out.println("\n");
                                break;

                            case 3:
                                System.out.println("\n" + "*** PosOrden ***");
                                System.out.print("Recorrido: { ");
                                arbol.raiz.printPosOrder();
                                System.out.println(" }");
                                System.out.println("\n");
                                break;
                        }
                    } while (opcion != 4);
                    break;
                    }
            }
        } while (opcion != 3);
    }
}
