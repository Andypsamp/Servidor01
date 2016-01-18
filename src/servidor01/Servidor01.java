/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor01;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Servidor01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   try {
            ServerSocket puerto = null;
            Socket canalComunicacion = null;
            InputStream bufferEntrada;
            DataInputStream datos;
            puerto = new ServerSocket(10831);
            canalComunicacion = puerto.accept();
            bufferEntrada = canalComunicacion.getInputStream();
            datos = new DataInputStream(bufferEntrada);
            String cadena = new String(datos.readUTF());
            while (cadena.length() > 0) {
                System.out.print(cadena);
                cadena = datos.readUTF();
            }
            datos.close();
            bufferEntrada.close();
            canalComunicacion.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
