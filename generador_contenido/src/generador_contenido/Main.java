/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generador_contenido;

/**
 *
 * @author Mario
 */
public class Main {
    
    public static void main(String[] args){
        Generador_contenido generador = new Generador_contenido("I");
        generador.generar_banco();
        System.out.println("le");
    }
    
}
