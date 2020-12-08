package ec.edu.ups.vista;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.modelo.Usuario;

/**
 * Servlet Filter implementation class FiltroEmpresa
 */
@WebFilter({"/FiltroSesion","/Admin/*","/User/*"})
public class FiltroSesion implements Filter {

    public FiltroSesion() { 

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {   
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		Usuario usuarioFil =(Usuario)session.getAttribute("usr");
		
		try {
			String tipUsu=String.valueOf(usuarioFil.getTipoUsu());
			if (usuarioFil!=null && tipUsu.equals("A")) {
				 chain.doFilter(request, response);
				//httpResponse.sendRedirect("/Practica01/Admin/Administrador.jsp");				
			} else if (usuarioFil!=null && tipUsu.equals("N")){
				 chain.doFilter(request, response);
				//httpResponse.sendRedirect("/Practica01/User/Usuario.jsp");
			}
		} catch (Exception e) {
			// System.out.println("1");
			session.invalidate();
			httpResponse.sendRedirect("/Practica01/index.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
