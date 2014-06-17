/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package campitos.servidor.servidorsockets;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author campitos
 */
public class ServidorSockets {
    String mensaje="Este mensaje es enviado desde el servidor :)";
    
    public void conectarse(){
        try{
        ServerSocket ss=new ServerSocket(5000);
        while(true){
            Socket socket=ss.accept();
            PrintWriter writer= new PrintWriter(socket.getOutputStream());
            String mensaje=getMensaje();
            writer.println(mensaje);
            writer.close();
            System.out.println(mensaje);
        }
        }catch(Exception e){
            
        }
    }
    public String getMensaje(){
        return mensaje;
    }
    public static void main(String args[]){
        ServidorSockets s=new ServidorSockets();
        s.conectarse();
    }
}
