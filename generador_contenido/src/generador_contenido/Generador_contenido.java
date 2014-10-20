/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generador_contenido;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    FileOutputStream sql;
    //el nombre del .sql sera comunidad_vecinos
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public Generador_contenido(String tipo) {
        try {
            sql = new FileOutputStream("comunidad_vecinos.sql");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
        }
        nBancos = 100;
        nAdmins = 20000;
        tipoCarga = tipo;
        nComunidades = 300000;
    }
    
    
    
    
    public void inserta_administrador(){
        for(int i = 1; i <= nAdmins; i++){
            
        }
    }
    
    public void generar_banco(){
        String value = "";
        String nombre;
        String contacto;
        for (int i = 1; i <= nBancos; i++) {
            nombre="'nombre"+i+"'";
            contacto="'contacto"+i+"'";
            if (tipoCarga.equals("C")){
                value=i+","+nombre+","+contacto;
            }else if (tipoCarga.equals("I")) {
                value="insert into administrador values("+i+","+nombre+","+contacto+")";
            }else if (tipoCarga.equals("P")) {
                value="select * from introducir_banco("+i+","+nombre+","+contacto+")";
            }
            value+=";\n";
            try {
                sql.write(value.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            sql.close();
        } catch (IOException ex) {
            Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generar_compania(){
        String value = "";
        String cif,nombre,direccion,sector,contacto,telefono = "";
        for (int i = 1; i <= nCompanias; i++) {
            cif = ""+i;
            nombre = "Nombre"+i;
            direccion = "Direccion"+i;
            sector = "Sector"+i;
            contacto = "Contacto"+i;
            telefono = "0091"+i; //nº obligatoriamente?
            if (tipoCarga.equals("C")) {
                value = "";
            } else if (tipoCarga.equals("I")) {
                value = "insert into administrador values("+cif+","+nombre+","+direccion+",+"+sector+","+contacto+","+telefono+")";
            } else if (tipoCarga.equals("P")) {
                value = "select * from introducir_compania("+cif+","+nombre+","+direccion+",+"+sector+","+contacto+","+telefono+")";
            }
            value += ";\n";
            try {
                sql.write(value.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            sql.close();
        } catch (IOException ex) {
            Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void generar_comunidad_vecinos(){
        String cCom, nCol, nombre, calle, codigo_postal, poblacion, honorarios = "";
        String value = "";
        Random random = new Random();
        for (int i = 1; i <= nComunidades; i++) {
            cCom = ""+i;
            nCol = ""+random.nextInt(nAdmins+1)+1;
            nombre = "'Nombre"+i+"'";
            calle = "'Calle"+i+"'";
            codigo_postal = ""+random.nextInt(10000)+1;
            poblacion = "'Poblacion"+i+"'";
            honorarios = ""+random.nextInt(10000)+"."+random.nextInt(100);
            if (tipoCarga.equals("C")) {
                value = "";
            } else if (tipoCarga.equals("I")) {
                value = "insert into comunidad_vecinos values("+cCom+","+nCol+","+nombre+",+"+calle+","+codigo_postal+","+poblacion+","+honorarios+")";
            } else if (tipoCarga.equals("P")) {
                value = "select * from insertar_comunidad_vecinos("+cCom+","+nCol+","+nombre+",+"+calle+","+codigo_postal+","+poblacion+","+honorarios+")";
            }
            value += ";\n";
            try {
                sql.write(value.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            sql.close();
        } catch (IOException ex) {
            Logger.getLogger(Generador_contenido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
