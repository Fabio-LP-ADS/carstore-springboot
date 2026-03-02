package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. Pega o valor do input do HTML
        String carName = req.getParameter("car-name");

        // 2. Monta manualmente a String no formato JSON que você pediu
        // Resultado: {"nome": "valor_digitado"}
        String jsonResponse = "{\"nome\": \"" + carName + "\"}";

        // 3. Exibe no console do servidor
        System.out.println("Processando objeto JSON: " + jsonResponse);

        // 4. Configura a resposta para o navegador como JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Escreve o JSON na tela para o usuário ver
        resp.getWriter().write(jsonResponse);
    }
}