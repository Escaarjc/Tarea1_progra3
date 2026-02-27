/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1_progra3;
import java.io.*;
import java.util.*;
/**
 *
 * @author escar
 */
public class Tarea1_Progra3 

 {

    static class Nodo {
        int valor;
        Nodo izquierda, derecha;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    static class ArbolBinario {
        Nodo raiz;

        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        private Nodo insertarRec(Nodo raiz, int valor) {
            if (raiz == null) {
                raiz = new Nodo(valor);
                return raiz;
            }

            if (valor < raiz.valor)
                raiz.izquierda = insertarRec(raiz.izquierda, valor);
            else if (valor > raiz.valor)
                raiz.derecha = insertarRec(raiz.derecha, valor);

            return raiz;
        }

        public boolean buscar(int valor) {
            return buscarRec(raiz, valor);
        }

        private boolean buscarRec(Nodo raiz, int valor) {
            if (raiz == null)
                return false;

            if (raiz.valor == valor)
                return true;

            if (valor < raiz.valor)
                return buscarRec(raiz.izquierda, valor);
            else
                return buscarRec(raiz.derecha, valor);
        }
    }

    public static void main(String[] args) throws IOException {

        int cantidad = 1000000; // Cambiar a 10000000 si tu PC lo soporta
        Random random = new Random();

        // 1️⃣ Generar archivo
        FileWriter writer = new FileWriter("numeros.txt");

        for (int i = 0; i < cantidad; i++) {
            int numero = random.nextInt(100000001) - 50000000;
            writer.write(numero + "\n");
        }

        writer.close();
        System.out.println("Archivo generado.");

        // 2️⃣ Cargar estructuras
        ArbolBinario arbol = new ArbolBinario();
        HashSet<Integer> tablaHash = new HashSet<>();

        BufferedReader reader = new BufferedReader(new FileReader("numeros.txt"));
        String linea;

        while ((linea = reader.readLine()) != null) {
            int numero = Integer.parseInt(linea);
            arbol.insertar(numero);
            tablaHash.add(numero);
        }

        reader.close();
        System.out.println("Estructuras cargadas.");

        // 3️⃣ Medir tiempo de búsqueda
        int pruebas = 1000;

        long inicioArbol = System.nanoTime();
        for (int i = 0; i < pruebas; i++) {
            int numero = random.nextInt(100000001) - 50000000;
            arbol.buscar(numero);
        }
        long finArbol = System.nanoTime();

        long inicioHash = System.nanoTime();
        for (int i = 0; i < pruebas; i++) {
            int numero = random.nextInt(100000001) - 50000000;
            tablaHash.contains(numero);
        }
        long finHash = System.nanoTime();

        double tiempoPromedioArbol = (finArbol - inicioArbol) / 1e6 / pruebas;
        double tiempoPromedioHash = (finHash - inicioHash) / 1e6 / pruebas;

        // 4️⃣ Mostrar tabla comparativa
        System.out.println("\nTABLA COMPARATIVA");
        System.out.println("---------------------------------------------");
        System.out.println("Estructura\tTiempo Promedio (ms)\tComplejidad");
        System.out.println("Árbol Binario\t" + tiempoPromedioArbol + "\t\tO(log n)");
        System.out.println("Tabla Hash\t" + tiempoPromedioHash + "\t\tO(1)");
    }
}
    

