package PrimerTrabajoEntornos;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Servidor {

    public static void main(String[] args) throws IOException {
        // Crear servidor en el puerto 8080
        HttpServer servidor = HttpServer.create(
                new InetSocketAddress(8080), 0);

        // Endpoint de prueba
        servidor.createContext("/loginHandler", new loginHandler());

        // Arrancar servidor
        servidor.start();

        System.out.println("Servidor iniciado en http://localhost:8080");
    }
}

class loginHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String respuesta = "Backend Actividad1EDD";

        exchange.sendResponseHeaders(200, respuesta.length());

        OutputStream os = exchange.getResponseBody();
        os.write(respuesta.getBytes());
        os.close();
    }
}