package entidad;

import lombok.Data;

@Data
public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String apellido;
	private String correo;
	private String fechaNac;
	private String dni;
	
}
