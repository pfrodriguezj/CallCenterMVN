package co.com.callcenter.CallCenterMvn;

/**
 * Models an employee. Types are OPERADOR, SUPERVISOR, DIRECTOR
 * An employee can be available or not.
 * @author felipe.jimenez
 *
 */
public class Empleado {

	public static final String TIPO_EMPLEADO_OPERADOR = "O";
	public static final String TIPO_EMPLEADO_SUPERVISOR = "S";
	public static final String TIPO_EMPLEADO_DIRECTOR = "D";

	private String codigo;
	private String tipo;
	private boolean available;

	public Empleado() {
		super();
	}

	public Empleado(String codigo, String tipo) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.available = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
