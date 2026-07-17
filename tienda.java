/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Hugo Cabello
 */
import java.util.Scanner;
public class tienda {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

int cantidad;
double importe, subtotal, iva, descuento, total;
String producto;
String respuesta;

subtotal = 0;

String[] productos = {"Leche", "Huevo", "Jamon", "Salchicha", "Tomate"};
double[] precios = {45.00, 56.00, 24.50, 23.50, 39.00};
int[] existencias = {30, 120, 35, 35, 50};

System.out.println("Bienvenido a la tiendita\nQue estaria llevando el dia de hoy?");

for (int i = 0; i < productos.length; i++) {
    System.out.println(i + "." + productos[i] + "\t" + "$" + precios[i] + "\t" + "Existencias:" + existencias[i]);
}

do {
    System.out.println("\nEscribe el nombre del producto que deseas llevar:");
    producto = teclado.next();

    // Buscar el producto en el arreglo (sin importar mayusculas/minusculas)
    int indice = -1;
    for (int i = 0; i < productos.length; i++) {
        if (productos[i].equalsIgnoreCase(producto)) {
            indice = i;
            break;
        }
    }

    if (indice == -1) {
        System.out.println("Ese producto no existe, intenta de nuevo.");
    } else {
        System.out.println("Cuantas piezas de " + productos[indice] + " quieres?");
        cantidad = teclado.nextInt();

        if (cantidad > existencias[indice]) {
            System.out.println("Lo sentimos, solo hay " + existencias[indice] + " piezas disponibles.");
        } else {
            importe = precios[indice] * cantidad;
            subtotal = subtotal + importe;
            existencias[indice] = existencias[indice] - cantidad; // Se descuenta del inventario

            System.out.println("Agregaste " + cantidad + " de " + productos[indice] + " = $" + importe);
        }
    }

    System.out.println("\nQuieres agregar otro producto? (si/no)");
    respuesta = teclado.next();

} while (respuesta.equalsIgnoreCase("si"));

descuento = subtotal * 0.15;
double subtotalConDescuento = subtotal - descuento;
iva = subtotalConDescuento * 0.16;
total = subtotalConDescuento + iva;

System.out.println("\n--- Resumen de tu compra ---");
System.out.println("Subtotal: $" + subtotal);
System.out.println("Descuento (15%): -$" + descuento);
System.out.println("IVA (16%): +$" + iva);
System.out.println("Total a pagar: $" + total);
    }
    
}
