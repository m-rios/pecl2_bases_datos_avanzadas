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
public class Generador_contenido {

    int nAdmins;
    int nComunidades;
    int nCompanias;
    int nBancos;
    String tipoCarga;//C->COPY; I->Insert; P->Procedimiento
    //el nombre del .sql sera comunidad_vecinos
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void generar_banco(){
        for (int i = 1; i <= nBancos; i++) {
            if (tipoCarga.equals("I")){
                
            }
        }
    }
    
}
