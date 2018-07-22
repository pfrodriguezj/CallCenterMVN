package co.com.callcenter.CallCenterMvn;

import java.util.ArrayList;
import java.util.List;

/**
 * Models the staff of call center. Singleton class.
 * Once initialized, every calling returns the List of employees
 * @author felipe.jimenez
 *
 */
public class Staff {

	private static List<Empleado> empleados = null;

	public static void initialize(int numOperadores, int numSupervisores, int numDirectores) {
		if (empleados == null) {
			empleados = new ArrayList<Empleado>();
			for (int i = 0; i < numOperadores; i++) {
				empleados.add(new Empleado("OP" + (i + 1), Empleado.TIPO_EMPLEADO_OPERADOR));
			}
			for (int i = 0; i < numSupervisores; i++) {
				empleados.add(new Empleado("SUP" + (i + 1), Empleado.TIPO_EMPLEADO_SUPERVISOR));
			}
		
			for (int i = 0; i < numDirectores; i++) {
				empleados.add(new Empleado("DIR" + (i + 1), Empleado.TIPO_EMPLEADO_DIRECTOR));
			}
		}
	}

	public static synchronized Empleado getAvailableEmployee() {
		Empleado emp = null;
		for (Empleado o : empleados) {
			if (o.getTipo().equals(Empleado.TIPO_EMPLEADO_OPERADOR) && o.isAvailable()) {
				emp = o;
				break;
			}
		}
		if (emp == null) {
			for (Empleado s : empleados) {
				if (s.getTipo().equals(Empleado.TIPO_EMPLEADO_SUPERVISOR) && s.isAvailable()) {
					emp = s;
					break;
				}
			}
		}
		if (emp == null) {
			for (Empleado d : empleados) {
				if (d.getTipo().equals(Empleado.TIPO_EMPLEADO_DIRECTOR) && d.isAvailable()) {
					emp = d;
					break;
				}
			}
		}
		if(emp!=null) {
			emp.setAvailable(false);
		}
		return emp;
	}

	public static int getAvailableEmployees() {
		int availableEmps = 0;
		for(Empleado e:empleados) {
			availableEmps = e.isAvailable()?availableEmps+1:availableEmps;
		}
		return availableEmps;
	}
}
