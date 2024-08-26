package PoliF1;

import java.util.Scanner;

public class Principal1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PoliF1 pol1 = new PoliF1(0, 0);
    PoliF1 pol2 = new PoliF1(0, 0);

    while (true) {

      System.out.println("Menu...");
      System.out.println("1.Insertar Polinomio 1 -\n2.Insertar Polinomio 2  \n3.Operar Polinomios");
      System.out.print("Elije una opcion: ");
      int op = 0;
      op = sc.nextInt();

      if (op == 1) {
        System.out.print("Ingrese el grado del polinomio 1: ");
        int grado = sc.nextInt();
        for (int i = 0; i <= grado; i++) {
          System.out.print("Ingrese coef: ");
          int coef = sc.nextInt();
          System.out.print("Ingrese exp: ");
          int exp = sc.nextInt();
          pol1.insertarTermino(coef, exp);
        }

      } else if (op == 2) {
        System.out.print("Ingrese el grado del polinomio 2: ");
        int grado = sc.nextInt();
        for (int i = 0; i <= grado; i++) {
          System.out.print("Ingrese coef: ");
          int coef = sc.nextInt();
          System.out.print("Ingrese exp: ");
          int exp = sc.nextInt();

          pol2.insertarTermino(coef, exp);
        }

      } else if (op == 3) {
        System.out.println("pol1\n" + pol1.mostrarPolinomio());
        System.out.println("pol2\n" + pol2.mostrarPolinomio());

        PoliF1 suma;

        suma = pol1.sumar(pol2);

        System.out.println("suma\n" + suma.mostrarPolinomio());

        pol1.eliminarTermino(2);
        System.out.println(pol1.mostrarPolinomio());

        PoliF1 producto;
        producto = pol1.multiplicar(pol2);

        System.out.println("producto: \n" + producto.mostrarPolinomio());
        break;
      }

    }
  }
}

