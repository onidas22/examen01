package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import model.ClienteModel;


@WebServlet("/insertaCliente")
public class ClienteControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1 Recibe los par�metros
			//Son los nombres de las caja de textos en el JSP
			String nom = request.getParameter("nombre");
			String ape = request.getParameter("apellido");
			String cor = request.getParameter("correo");
			String fec = request.getParameter("fecha");
			String dni = request.getParameter("dni");
			
			//2 Se crea el objeto Cliente
			Cliente obj = new Cliente();
			obj.setNombre(nom);
			obj.setApellido(ape);
			obj.setCorreo(cor);
			obj.setFechaNac(fec);
			obj.setDni(dni);
			
			ClienteModel m = new ClienteModel();
			int s = m.insertaCliente(obj);
			if (s>0)
				request.getSession().setAttribute("MENSAJE", "registro exitoso");
			else
				request.getSession().setAttribute("MENSAJE", "registro err�neo");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("MENSAJE", "registro err�neo");
		} finally {
			response.sendRedirect("registraCliente.jsp");
		}
	}

}
