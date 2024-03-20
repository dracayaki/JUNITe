package org.iesvdm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AlturaAlumnoTest {

    @Test
    void verdadero() {

        Assertions.assertTrue(1 == 1);
    }

    @Test
    void anadeNombre() {

        final String[] array = new String[10];

        array[0] = "Jose";
        String nombre = "Maria";
        String[] arrayActual = AlturaAlumno.anadeNombre(array, nombre);

        assertTrue(arrayActual[arrayActual.length - 1].equals(nombre));
    }

    @Test
    void anadeNombre2() {

        final String[] array = new String[0];

        int longInicial = array.length;

        String nombre = "Maria";
        String[] arrayActual = AlturaAlumno.anadeNombre(array, nombre);

        assertEquals(longInicial + 1, arrayActual.length);
        assertTrue(arrayActual[arrayActual.length - 1].equals(nombre));
    }

    @Test
    void modificarAlturaTest() {

        //When
        double[] array = {1.6, 1.8, 1.7};
        double[] aux = Arrays.copyOf(array, array.length);
        int posicion = 1;
        double altura = 1.9;
        //Do
        AlturaAlumno.modificaAltura(array, posicion, altura);
        //Then


        //altura esta en la posicion
        assertTrue(altura == array[posicion]);


        //Todos los demas elementos del array cambian
        for (int i = 0; i < array.length; i++) {
            if (i != posicion) {
                Assertions.assertEquals(array[i], aux[i]);
            }
        }

    }

    @Test
    void modificarAlturaPosicionFueraDeRango(){

        //When
        double[] array = {1.6, 1.8, 1.7};
        double[] aux = Arrays.copyOf(array, array.length);
        int posicion = array.length +2;
        double altura = 1.9;
        //Do
        AlturaAlumno.modificaAltura(array, posicion, altura);
        //Then
        Assertions.assertArrayEquals(aux, array);
    }

    @Test
    void buscarNombreEncontrado() {
        //when//
        String[] array = {"Juan", "Ana", "Luis"};
        String nombre = "Ana";
        //do//
        AlturaAlumno.buscaNombre(array, nombre);
        //then//
        assertEquals(1, AlturaAlumno.buscaNombre(array, nombre));

    }

    @Test
    void buscarNombreNoEncontrado() {
        //when//
        String[] array = {"Juan", "Ana", "Luis"};
        String nombre = "Pepe";
        //do//
        //AlturaAlumno.buscaNombre(array, nombre);
        //then//
        assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
        assertEquals(-1, AlturaAlumno.buscaNombre(array, null));


    }

    @Test
    void buscarNombreArrayVacio() {
        //when//
        String[] array = {};
        String nombre = "Pepe";
        //do//
        AlturaAlumno.buscaNombre(array, nombre);
        //then//
        assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
    }

    @Test
    void buscarNombreNull() {
        //when//
        String[] array = {"Juan", "Ana", "Luis"};
        //String nombre = null;
        //do//
        // AlturaAlumno.buscaNombre(array, nombre);
        //then//
        assertEquals(-1, AlturaAlumno.buscaNombre(array, " "));
    }

    @Test
    void mostrarTestCorrecto() {
        //when//
        String[] array = {"Juan", "Ana", "Luis"};
        double[] alturas = {1.9, 1.78, 1.67};

        //do-then//
        assertDoesNotThrow(() -> {
            AlturaAlumno.mostrar(array, alturas);
        });
    }

    @Test
    void mostrarTestAFallo() {
        //when//
        String[] array = {"Juan", "Ana", "Luis"};
        double[] alturas = {1.9, 1.78}; //falla porque no tienen la misma longitud

        //do-then//
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            AlturaAlumno.mostrar(array, alturas);
        });
    }

    @Test
    void calcularMaximoTest() {
        double[] array = {1.78, 1.9, 1.5};

        double[] resultado = {1, 1.9};
        Assertions.assertArrayEquals(resultado, AlturaAlumno.calculaMaximo(array));
    }

    @Test
    void calcularMaximoVacio() {

        double[] array = {};
        double[] resultado = {0, 0};

        Assertions.assertArrayEquals(resultado, AlturaAlumno.calculaMaximo(array));


    }

    @Test
    void calcularMaximoExtremo() {

        double[] array = {0, -1, -7.8};
        double[] resultado = {0, 0};

        Assertions.assertArrayEquals(resultado, AlturaAlumno.calculaMaximo(array));


    }

    @Test
    void calculaMediaTest() {
        double[] array = {1.6, 1.82, 1.77};
        double res = (1.6 + 1.82 + 1.77) / 3;

        Assertions.assertEquals(res, AlturaAlumno.calculaMedia(array));
    }

    @Test
    void calculaMediaVacio() {
        double[] array = {};

        Assertions.assertEquals(0, AlturaAlumno.calculaMedia(array));
    }

    @Test
    void calculaMediaExtremos(){
        double[] array = {-2, 4, 0};

        double res = (double)(-2 + 4 + 0) / 3;

        Assertions.assertEquals(res, AlturaAlumno.calculaMedia(array));
    }
}
